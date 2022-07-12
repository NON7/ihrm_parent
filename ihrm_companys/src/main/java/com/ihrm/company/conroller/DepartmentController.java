package com.ihrm.company.conroller;

import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.DeptListResult;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.company.service.DepartmentService;
import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class DepartmentController extends BaseController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CompanyService companyService;
    /**
     * 添加部门
     */
    @PostMapping("/departments")
    public Result add(@RequestBody Department department){
        department.setCompanyId(parseCompanyId());
        departmentService.save(department);
        return Result.SUCCESS();
    }
    /**
     * 修改部门信息
     */
    @PutMapping("/departments/{id}")
    public Result update(@PathVariable(name="id") String id,@RequestBody Department department) throws Exception{
        department.setCompanyId(parseCompanyId());
        department.setId(id);
        departmentService.update(department);
        return Result.SUCCESS();
    }

    /**
     * 删除部门
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/departments/{id}")
    public Result delete(@PathVariable(name="id") String id) throws Exception{
        departmentService.delete(id);
        return Result.SUCCESS();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/departments/{id}")
    public Result findById(@PathVariable(name="id") String id) throws  Exception{
        Department department=departmentService.findById(id);
        return new Result(ResultCode.SUCCESS,department);
    }
    
    public Result findAll() throws Exception{
        Company company = companyService.findById(parseCompanyId());
        List<Department> list=departmentService.findAll(parseCompanyId());
        return new Result(ResultCode.SUCCESS,new DeptListResult(company,list));

    }
}
