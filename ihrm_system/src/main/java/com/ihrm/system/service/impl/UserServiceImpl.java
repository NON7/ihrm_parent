package com.ihrm.system.service.impl;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.domain.system.Role;
import com.ihrm.domain.system.User;
import com.ihrm.system.dao.RoleDao;
import com.ihrm.system.dao.UserDao;
import com.ihrm.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Override
    public User findByMobileAndPassword(String mobile, String password) {
        User user = userDao.findByMobile(mobile);
        if(user!=null&&password.equals(user.getPassword())){
            return user;
        }else{
            return null;
        }
    }

    @Override
    public void save(User user) {
        user.setId(idWorker.nextId()+"");
        user.setCreateTime(new Date());
        user.setPassword("123456");
        user.setEnableState(1);//状态
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        User targer = userDao.findById(user.getId()).get();
        targer.setPassword(user.getPassword());
        targer.setUsername(user.getUsername());
        targer.setMobile(user.getMobile());
        targer.setDepartmentId(user.getDepartmentId());
        targer.setDepartmentName(user.getDepartmentName());
        userDao.save(targer);


    }

    @Override
    public User findById(String id) {
        return userDao.findById(id).get();
    }

    @Override
    public void delete(String id) {
        userDao.deleteById(id);
    }

    @Override
    public Page<User> findSearch(Map<String, Object> map, int page, int size) {
        return userDao.findAll(createSpecification(map), PageRequest.of(page-1,size));
    }

    @Override
    public void changeDept(String deptId, String deptName, List<String> ids) {
        for (String id : ids) {
            User user=userDao.findById(id).get();
            user.setDepartmentName(deptName);
            user.setDepartmentId(deptId);
            userDao.save(user);
        }
    }

    @Override
    public void assignRoles(String userId, List<String> roleIds) {
        User user=userDao.findById(userId).get();
        Set<Role> roles=new HashSet<>();
        for (String id : roleIds) {
            Role role=roleDao.findById(id).get();
            roles.add(role);
        }

//        设置用户和角色之间的关系
        user.setRoles(roles);
        userDao.save(user);
    }

    /**
     * 动态条件创建
     * @param searchMap
     * @return
     */
    @Override
    public Specification<User> createSpecification(Map searchMap) {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList=new ArrayList<Predicate>();
                //id
                if(searchMap.get("id")!=null&&!"".equals(searchMap.get("id"))){
                    predicateList.add(criteriaBuilder.equal(root.get("id").as(String.class),(String)searchMap.get("id")));
                }
                //手机号码
                if(searchMap.get("mobile")!=null&&!"".equals(searchMap.get("mobile"))){
                    predicateList.add(criteriaBuilder.equal(root.get("mobile").as(String.class),(String)searchMap.get("mobile")));
                }
                //用户id
                if(searchMap.get("departmentId")!=null&&!"".equals(searchMap.get("departmentId"))){
                    predicateList.add(criteriaBuilder.equal(root.get("departmentId").as(String.class),(String)searchMap.get("departmentId")));
                }
//                标题
                if(searchMap.get("formOfEmployment")!=null&&!"".equals(searchMap.get("formOfEmployment"))){
                    predicateList.add(criteriaBuilder.equal(root.get("formOfEmployment").as(String.class),(String)searchMap.get("formOfEmployment")));
                }

                if(searchMap.get("companyId")!=null&&!"".equals(searchMap.get("companyId"))){
                    predicateList.add(criteriaBuilder.equal(root.get("companyId").as(String.class),(String)searchMap.get("companyId")));
                }

                if(searchMap.get("hasDept")!=null&&!"".equals(searchMap.get("hasDept"))){
                    if("0".equals((String)searchMap.get("hasDept"))){
                        predicateList.add(criteriaBuilder.isNull(root.get("departmentId")));
                    }else{
                        predicateList.add(criteriaBuilder.isNotNull(root.get("departmentId")));

                    }
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };

    }
}
