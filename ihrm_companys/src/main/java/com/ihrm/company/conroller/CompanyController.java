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
    public Result save(@RequestBody Company company) throws Exception{
        companyService.add(company);
        return Result.SUCCESS();
    }
//    根据id更新企业
    @PutMapping("/{id}")
    public Result update(@PathVariable(name="id") String id,@RequestBody Company company) throws Exception{
        Company one=companyService.findById(id);
        one.setName((company.getName()));
        one.setRemarks(company.getRemarks());
        one.setState(company.getState());
        one.setAuditState(company.getAuditState());
        companyService.update(company);
        return Result.SUCCESS();
    }
//    根据id删除企业
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") String id) throws Exception{
        companyService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

//    根据id查询企业
    @GetMapping("/{id}")
    public Result findById(@PathVariable(name="id") String id) throws Exception{
        Company company = companyService.findById(id);
        return new Result(ResultCode.SUCCESS,company);
    }

//    查询全部
    @GetMapping
    public Result findAll() throws Exception {
        List<Company> list = companyService.findAll();
        return new Result(ResultCode.SUCCESS,list);
    }

}
