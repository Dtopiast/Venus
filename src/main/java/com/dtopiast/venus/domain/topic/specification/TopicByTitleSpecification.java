package com.dtopiast.venus.domain.topic.specification;

import com.dtopiast.venus.domain.base.MySpecification;
import com.dtopiast.venus.domain.topic.model.Topic;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class TopicByTitleSpecification extends MySpecification<Topic> {

    private final  String title;
    public TopicByTitleSpecification(String title){
        this.title = title;
    }

    @Override
    protected Predicate buildPredicate(Root<Topic> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(criteriaBuilder.lower(root.get("title")),"%"+ title.toLowerCase() +"%");
    }
}
