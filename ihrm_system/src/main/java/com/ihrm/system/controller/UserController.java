package com.ihrm.system.controller;

import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.PageResult;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.domain.system.User;
import com.ihrm.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/sus")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public Result add(@RequestBody User user) throws Exception{
        user.setCompanyId(parseCompanyId());
        user.setCompanyName(parseCompanyName());
        userService.save(user);
        return Result.SUCCESS();
    }

    @PutMapping("/user/{id}")
    public Result update(@PathVariable(name="id") String id,@RequestBody User user){
        userService.update(user);
        return Result.SUCCESS();
    }
    @DeleteMapping("/user/{id}")
    public Result delete(@PathVariable(name="id") String id) throws Exception{
        userService.delete(id);
        return Result.SUCCESS();
    }

    @GetMapping("/user/{id}")
    public Result findById(@PathVariable(name="id") String id) throws Exception{
        User user = userService.findById(id);
        return new Result(ResultCode.SUCCESS,user);
    }

    @GetMapping("/user")
    public Result findByPage(int page,int pagesize,@RequestParam Map<String,Object> map) throws Exception{
        map.put("companyId",parseCompanyId());
        Page<User> searchPage = userService.findSearch(map, page, pagesize);
        PageResult pr = new PageResult(searchPage.getTotalElements(), searchPage.getContent());
        return new Result(ResultCode.SUCCESS,pr);

    }


}
