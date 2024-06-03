package com.dtopiast.venus.domain.user.specification;

import com.dtopiast.venus.domain.base.MySpecification;
import com.dtopiast.venus.domain.role.model.Role;
import com.dtopiast.venus.domain.user.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class UserByNameSpecification extends MySpecification<User> {

    private final  String name;
    public UserByNameSpecification(String name){
        this.name = name;
    }

    @Override
    protected Predicate buildPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+name.toLowerCase() +"%");
    }
}
