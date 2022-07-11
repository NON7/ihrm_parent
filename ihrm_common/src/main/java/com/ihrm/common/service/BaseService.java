package com.ihrm.common.service;

import org.springframework.data.jpa.domain.Specification;

public class BaseService<T> {
    protected Specification<T> getSpecification(String companyId){
        return new Specification<T>(){
            public Predicated toPredicate(Root<T> root,CriteraQuery<?> criteriaQuery,CriteriaBuilder cb){
                return cb.equal(root.get("companyId").as(String.class).companyId);
            }
        }
    }
}
