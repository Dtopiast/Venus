package com.dtopiast.venus.domain.course.model;

import com.dtopiast.venus.domain.category.model.Category;
import com.dtopiast.venus.domain.topic.model.Topic;
import com.dtopiast.venus.domain.base.MyModel;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a course in the system.
 */
@Table(name = "course")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course extends MyModel {

    /**
     * The name of the course.
     */
    private String name;

    /**
     * The topic associated with the course.
     */
    @ManyToOne
    private Topic topic;

    /**
     * The categories associated with the course.
     */
    @ManyToMany
    private List<Category> categories;

    public void updateName(String name) {
        this.name = name;
    }
}
