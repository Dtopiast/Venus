package com.dtopiast.venus.core.service.course;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.course.model.Course;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ICourseQueryService extends MyService {
    List<Course> getAllCourses();

    <T extends Specification<Course>> List<Course> getAllCoursesBySpecification(T specification);

    Course getCourseByName(String name);

    Course getCourseById(Long id);
}