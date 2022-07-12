package com.ihrm.system.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.domain.system.User;
import com.ihrm.system.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface UserService {
    public User findByMobileAndPassword(String mobile,String password);
//    添加用户
    public void save(User user);
//    更新用户
    public void update(User user);
//    根据ID查询用户
    public User findById(String id);
//    删除部门
    public void delete(String id);
    public Page<User> findSearch(Map<String,Object> map, int page, int size);
//    调整部门
    public void changeDept(String deptId, String deptName, List<String> ids);
//    分配角色
    public void assignRoles(String userId,List<String> roleIds);
//    动态条件构建
    Specification<User> createSpecification(Map searchMap);



}
