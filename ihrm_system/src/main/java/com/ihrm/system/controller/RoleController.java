package com.ihrm.system.controller;

import com.ihrm.common.entity.PageResult;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.domain.system.Role;
import com.ihrm.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/role")
    public Result add(@RequestBody Role role) throws Exception{
        String companyId="1";
        role.setCompanyId(companyId);
        roleService.save(role);
        return Result.SUCCESS();
    }

    @PutMapping("/role/{id}")
    public Result update(@PathVariable(name="id") String id,@RequestBody Role role){
        roleService.update(role);
        return Result.SUCCESS();
    }

    @DeleteMapping("/role/{id}")
    public Result delete(@PathVariable(name="id") String id)throws  Exception{
        roleService.delete(id);
        return Result.SUCCESS();
    }
    @GetMapping("/role/{id}")
    public Result findById(@PathVariable(name="id") String id) throws  Exception{
        Role role = roleService.findById(id);
        return new Result(ResultCode.SUCCESS,role);
    }


    /**
     * 分页查询角色
     * @param page
     * @param pagesize
     * @param role
     * @return
     * @throws Exception
     */
    @GetMapping("/role")
    public Result findByPage(int page,int pagesize,Role role) throws Exception{
        String companyId="1";
        Page<Role> searchPage = roleService.findSearch(companyId, page, pagesize);
        PageResult pr = new PageResult(searchPage.getTotalElements(), searchPage.getContent());
        return new Result(ResultCode.SUCCESS,pr);
    }
}
