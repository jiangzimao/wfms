package org.jqiaofu.wfms.web.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jqiaofu.wfms.model.SysMenu;
import org.jqiaofu.wfms.model.SysOperation;
import org.jqiaofu.wfms.model.SysRole;
import org.jqiaofu.wfms.repository.SysMenuPepository;
import org.jqiaofu.wfms.repository.SysOperationRepository;
import org.jqiaofu.wfms.repository.SysRoleRepository;
import org.jqiaofu.wfms.web.util.AntUrlPathMatcher;
import org.jqiaofu.wfms.web.util.UrlMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

/*
 * 
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。
 * 注意，我例子中使用的是AntUrlPathMatcher这个path matcher来检查URL是否与资源定义匹配，
 * 事实上你还要用正则的方式来匹配，或者自己实现一个matcher。
 * 
 * 此类在初始化时，应该取到所有资源及其对应角色的定义
 * 
 * 说明：对于方法的spring注入，只能在方法和成员变量里注入， 如果一个类要进行实例化的时候，不能注入对象和操作对象，
 * 所以在构造函数里不能进行操作注入的数据。
 */
@Component
public class InvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource ,InitializingBean{
	//系统菜单默认权限
	private static final String NORMAL_USER_ROLE = "NORMAL_USER"; 
	
	@Autowired
	private SysMenuPepository sysMenuPepository;
	
	@Autowired
	private SysRoleRepository sysRoleRepository;
	
	@Autowired
	private SysOperationRepository sysOperationRepository;
	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(AccessDecisionManager.class);

	private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	// tomcat启动时实例化一次
	@Override
	public void afterPropertiesSet() throws Exception {
		loadResourceDefine();
	}
	
	public void reflashResourceDefine(){
		loadResourceDefine();
	}

	// tomcat开启时加载一次，加载所有url和权限（或角色）的对应关系
	private void loadResourceDefine() {
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		Iterable<SysMenu> menuList = sysMenuPepository.findAll();
		for (SysMenu sysMenu : menuList) {
			if(sysMenu.getIsleaf() == 1){
				Iterable<SysOperation> sysOperationList = sysOperationRepository.findByMenuId(sysMenu.getMenuId());
				String actionUrl = sysMenu.getActionUrl();
				Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
				//添加系统默认角色
				atts.add(new SecurityConfig(NORMAL_USER_ROLE));
				for (SysOperation sysOperation : sysOperationList) {
					SysRole sysRole = sysRoleRepository.findOne(sysOperation.getOperationCode());
					ConfigAttribute ca = new SecurityConfig(sysRole.getRoleCode());
					atts.add(ca);
				}
				logger.info("URL["+ actionUrl + "] 访问权限：" + Arrays.toString(atts.toArray()));
				resourceMap.put(actionUrl, atts);
			}
		}
	}

	// 参数是要访问的url，返回这个url对于的所有权限（或角色）
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		// 将参数转为url
		String url = ((FilterInvocation) object).getRequestUrl();
		if(url.startsWith("/")){
			url = url.substring(1);
		}
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			if (urlMatcher.pathMatchesUrl(resURL, url)) {
				return resourceMap.get(resURL);
			}
		}
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

}