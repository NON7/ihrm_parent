package com.ihrm.system.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.domain.system.Role;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {
    public void save(Role role);
    public void update(Role role);
    public Role findById(String id);
    public void delete(String id);
    public Page<Role> findSearch(String companyId,int page,int size);
    public void assignPerms(String roleId, List<String> permIds);
}
