package com.ihrm.system.service;

import com.ihrm.domain.system.Permission;

import java.util.List;
import java.util.Map;

public interface PermissionService {
    public void save(Map<String,Object> map);
    public void update(Map<String,Object> map);
    public Map<String,Object> findById(String id);
    public List<Permission> findAll(Map<String ,Object> map);
    public void deleteById(String id);
}
