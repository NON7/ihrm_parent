package com.ihrm.company.service;

import com.ihrm.common.service.BaseService;
import com.ihrm.domain.company.Department;

import java.util.List;

public interface DepartmentService{
    public void save(Department department);
    public void update(Department department);
    public Department findById(String id);
    public void delete(String id);
    public List<Department> findAll(String companyId);
}
