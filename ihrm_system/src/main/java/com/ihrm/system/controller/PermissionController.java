package com.ihrm.system.controller;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.domain.system.Permission;
import com.ihrm.system.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys")
@CrossOrigin
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    /**
     * 保存
     */
    @PostMapping("/permission")
    public Result save(@RequestBody Map<String,Object> map)throws Exception{
        permissionService.save(map);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 修改
     */
    @PutMapping("/permission/{id}")
    public Result update(@PathVariable(value="id")String id,@RequestBody Map<String,Object> map)throws Exception{
        //构造函数
        map.put("id",id);
        permissionService.update(map);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 查询列表
     */
    @GetMapping("/Permission")
    public Result findAll(@RequestBody Map map)throws Exception{
        List<Permission> list = permissionService.findAll(map);
        return new Result(ResultCode.SUCCESS,list);

    }
    /**
     * 根据id查询
     */
    @GetMapping("/permission/{id}")
    public Result findById(@PathVariable(value="id")String id)throws Exception{
        Map map = permissionService.findById(id);
        return new Result(ResultCode.SUCCESS,map);

    }

    /**
     * 根据id删除
     */
    @DeleteMapping("/permission/{id}")
    public Result deleteById(@PathVariable(value="id")String id)throws Exception{
        permissionService.deleteById(id);
        return new Result(ResultCode.SUCCESS);

    }
}
