package org.jqiaofu.wfms.repository;

import java.util.List;

import org.jqiaofu.wfms.model.SysRole;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleRepository extends JpaRepository<SysRole, String>, JpaSpecificationExecutor<SysRole>{

	public List<SysRole> findAll(Specification<SysRole> specification);

	public long count(Specification<SysRole> specification);
}
