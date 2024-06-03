package com.dtopiast.venus.domain.category.model;

import com.dtopiast.venus.domain.course.model.Course;
import com.dtopiast.venus.domain.base.model.MyModel;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a category in the system.
 */
@Table(name = "category")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends MyModel {

    /**
     * The courses associated with the category.
     */
    @ManyToMany
    public List<Course> courses;
    /**
     * The name of the category.
     */
    private String name;
}
