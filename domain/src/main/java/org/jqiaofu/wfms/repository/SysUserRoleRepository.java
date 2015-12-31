package org.jqiaofu.wfms.repository;

import java.util.List;

import org.jqiaofu.wfms.model.SysUserRole;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRoleRepository extends JpaRepository<SysUserRole, String>, JpaSpecificationExecutor<SysUserRole> {

	public List<SysUserRole> findByUserId(String userId);

	public int deleteByRoleId(String roleId);

	public int deleteByUserId(String userId);

	public List<SysUserRole> findAll(Specification<SysUserRole> specification);

}
