package com.ihrm.domain.system;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 权限菜单（权限点）实体类
 */
@Entity
@Table(name="pe_permission_point")
@Getter
@Setter
public class PermissionPoint implements Serializable {
    private static final long serialVersionUID=-1002411490113957485L;
    @Id
    private String id;
    private String pointclass;
    private String pointIcon;
    private String pointStatus;
}
