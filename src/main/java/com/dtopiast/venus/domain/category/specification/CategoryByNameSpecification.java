package com.dtopiast.venus.domain.category.specification;

import com.dtopiast.venus.domain.base.MySpecification;
import com.dtopiast.venus.domain.category.model.Category;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CategoryByNameSpecification extends MySpecification<Category> {

    private final  String name;
    public  CategoryByNameSpecification(String name){
        this.name = name;
    }

    @Override
    protected Predicate buildPredicate(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+name.toLowerCase() +"%");
    }
}
