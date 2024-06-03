package com.dtopiast.venus.domain.profile.specification;

import com.dtopiast.venus.domain.base.MySpecification;
import com.dtopiast.venus.domain.course.model.Course;
import com.dtopiast.venus.domain.profile.model.Profile;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ProfileByNameSpecification extends MySpecification<Profile> {

    private final String name;
    public ProfileByNameSpecification(String name){
        this.name = name;
    }

    @Override
    protected Predicate buildPredicate(Root<Profile> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+name.toLowerCase() +"%");
    }
}
