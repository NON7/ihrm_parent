package com.ihrm.common.service;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BaseService<T> {
    protected Specification<T> getSpecification(String companyId){
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("companyId").as(String.class),companyId);
            }
        };
//        return new Specification<T>(){
//            public Predicated toPredicate(Root<T> root,CriteraQuery<?> criteriaQuery,CriteriaBuilder cb){
//                return cb.equal(root.get("companyId").as(String.class).companyId);
//            }
//        };

    }
}
