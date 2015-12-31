package org.jqiaofu.wfms.repository;

import java.util.List;

import org.jqiaofu.wfms.model.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMenuPepository extends JpaRepository<SysMenu, String> {

	public List<SysMenu> findByStatus(String status);

}
