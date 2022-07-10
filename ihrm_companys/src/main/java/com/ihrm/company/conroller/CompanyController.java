package com.ihrm.company.conroller;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.domain.Company;
import com.ihrm.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin //跨域注解
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    public CompanyService companyService;

//    保存企业
    @PostMapping
    public Result save(@RequestBody Company company){
        companyService.add(company);
        return new Result(ResultCode.SUCCESS);
    }
//    根据id更新企业
    @PutMapping("/{id}")
    public Result update(@PathVariable String id,@RequestBody Company company){
        company.setId(id);
        companyService.update(company);
        return new Result(ResultCode.SUCCESS);
    }
//    根据id删除企业
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") String id){
        companyService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

//    根据id查询企业
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") String id){
        Company company = companyService.findById(id);
        return new Result(ResultCode.SUCCESS,company);
    }

//    查询全部
    @GetMapping
    public Result findAll(){
        List<Company> list = companyService.findAll();
        return new Result(ResultCode.SUCCESS,list);
    }

}
