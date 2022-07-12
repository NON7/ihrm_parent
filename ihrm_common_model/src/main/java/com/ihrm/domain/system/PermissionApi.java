package com.ihrm.domain.system;

import javax.persistence.Id;
import java.io.Serializable;

public class PermissionApi implements Serializable {
    private static final long serialVersionUID=-1803315043290784820L;
    @Id
    private String id;
    private String apiUrl;
    private String apiMethod;
    private String apiLevel;//权限等级：1-通用接口权限，2-需校验接口权限
}
