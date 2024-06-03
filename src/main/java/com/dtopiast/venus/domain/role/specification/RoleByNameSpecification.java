package com.dtopiast.venus.domain.role.specification;

import com.dtopiast.venus.domain.base.MySpecification;
import com.dtopiast.venus.domain.category.model.Category;
import com.dtopiast.venus.domain.role.model.Role;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class RoleByNameSpecification extends MySpecification<Role> {

    private final  String name;
    public RoleByNameSpecification(String name){
        this.name = name;
    }

    @Override
    protected Predicate buildPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+name.toLowerCase() +"%");
    }
}
