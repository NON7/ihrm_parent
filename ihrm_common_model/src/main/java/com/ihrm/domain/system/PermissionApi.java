package com.ihrm.domain.system;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name="pe_permission_point")
@Getter
@Setter
public class PermissionApi implements Serializable {
    private static final long serialVersionUID=-1803315043290784820L;
    @Id
    private String id;
    private String apiUrl;
    private String apiMethod;
    private String apiLevel;//权限等级：1-通用接口权限，2-需校验接口权限
}
