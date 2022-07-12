package com.ihrm.company.dao;

import com.ihrm.domain.system.PermissionPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 权限按钮（点）持久化类
 */
public interface PermissionPoingDao extends JpaRepository<PermissionPoint,String>, JpaSpecificationExecutor<PermissionPoint> {
}
