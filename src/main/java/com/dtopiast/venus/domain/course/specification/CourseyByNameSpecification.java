package com.dtopiast.venus.domain.course.specification;

import com.dtopiast.venus.domain.base.MySpecification;
import com.dtopiast.venus.domain.category.model.Category;
import com.dtopiast.venus.domain.course.model.Course;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CourseyByNameSpecification extends MySpecification<Course> {

    private final String name;
    public CourseyByNameSpecification(String name){
        this.name = name;
    }

    @Override
    protected Predicate buildPredicate(Root<Course> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+name.toLowerCase() +"%");
    }
}
