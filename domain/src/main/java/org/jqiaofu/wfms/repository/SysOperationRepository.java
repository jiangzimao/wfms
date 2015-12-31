package org.jqiaofu.wfms.repository;

import org.jqiaofu.wfms.model.SysOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SysOperationRepository extends JpaRepository<SysOperation, String>, JpaSpecificationExecutor<SysOperation> {

	public Iterable<SysOperation> findByMenuId(String menuId);

	public void deleteByOperationCode(String operationCode);

	public void deleteByOperationCodeAndStatus(String operationCode, String status);

}
