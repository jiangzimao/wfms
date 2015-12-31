package org.jqiaofu.wfms.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jqiaofu.wfms.model.SysRole;
import org.jqiaofu.wfms.model.SysUser;
import org.jqiaofu.wfms.model.SysUserRole;
import org.jqiaofu.wfms.repository.SysRoleRepository;
import org.jqiaofu.wfms.repository.SysUserRepository;
import org.jqiaofu.wfms.repository.SysUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private SysUserRepository sysUserRepository;
	@Autowired
	private SysUserRoleRepository sysUserRoleRepository;
	@Autowired
	private SysRoleRepository sysRoleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		SysUser sysUser = sysUserRepository.findByUserName(userName);
		if(sysUser != null){
			List<SysUserRole> userRolelist = sysUserRoleRepository.findByUserId(sysUser.getUserId());
			for (SysUserRole sysUserRole : userRolelist) {
				SysRole sysRole = sysRoleRepository.findOne(sysUserRole.getRoleId());
				if(sysRole != null){
					authorities.add(new SimpleGrantedAuthority(sysRole.getRoleCode()));
				}
			}
		}
		return new User(userName, sysUser.getPassword(), sysUser.isEnabled(), 
				sysUser.isAccountNonExpired(), sysUser.isCredentialsNonExpired(), 
				sysUser.isAccountNonLocked(), authorities);
	}

}
