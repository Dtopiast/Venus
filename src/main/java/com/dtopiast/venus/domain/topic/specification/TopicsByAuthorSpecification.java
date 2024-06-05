package com.dtopiast.venus.domain.topic.specification;

import com.dtopiast.venus.domain.base.MySpecification;
import com.dtopiast.venus.domain.topic.model.Topic;
import com.dtopiast.venus.domain.user.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class TopicsByAuthorSpecification extends MySpecification<Topic> {

    private final  String author;
    public TopicsByAuthorSpecification(String author){
        this.author = author;
    }

    @Override
    protected Predicate buildPredicate(Root<Topic> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),"%"+ author.toLowerCase() +"%");
    }}

