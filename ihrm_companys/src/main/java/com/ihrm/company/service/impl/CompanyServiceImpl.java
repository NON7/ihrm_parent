package com.ihrm.company.service.impl;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.CompanyDao;
import com.ihrm.company.service.CompanyService;
import com.ihrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private IdWorker idWorker;
    @Override
    public Company add(Company company) {
//        基本属性的设置
        String l = idWorker.nextId()+"";
        company.setId(l);
//        默认的状态
        company.setAuditState("0");//0：未审核；1：已审核
        company.setState(1);//0：未激活，1：已审核
        return companyDao.save(company);
    }

    /**
     * 更新企业
     * 1.更新操作永远先查再更新
     * @param company
     */
    @Override
    public Company update(Company company) {
        Company temp = companyDao.findById(company.getId()).get();
        temp.setName(company.getName());
        temp.setCompanyPhone(company.getCompanyPhone());
        return companyDao.save(temp);
    }

    @Override
    public void deleteById(String id) {
        companyDao.deleteById(id);

    }

    @Override
    public Company findById(String id) {
        return companyDao.findById(id).get();
    }

    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }
}
