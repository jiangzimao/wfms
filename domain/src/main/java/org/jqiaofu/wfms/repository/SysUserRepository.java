package org.jqiaofu.wfms.repository;

import java.util.List;

import org.jqiaofu.wfms.model.SysUser;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, String>, JpaSpecificationExecutor<SysUser> {

	public SysUser findByUserName(String userName);

	public SysUser findByUserId(String userId);

	public long count(Specification<SysUser> specification);

	public List<SysUser> findAll(Specification<SysUser> specification);

}
