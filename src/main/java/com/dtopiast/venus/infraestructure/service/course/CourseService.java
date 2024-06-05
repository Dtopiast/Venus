package com.dtopiast.venus.infraestructure.service.course;

import com.dtopiast.venus.core.service.course.ICourseService;
import com.dtopiast.venus.core.service.repository.IRepository;
import com.dtopiast.venus.domain.category.model.Category;
import com.dtopiast.venus.domain.course.dto.*;
import com.dtopiast.venus.domain.course.model.Course;
import com.dtopiast.venus.domain.course.specification.CourseByNameSpecification;
import com.dtopiast.venus.domain.topic.model.Topic;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CourseService implements ICourseService {
    private final IRepository<Course> courseRepository;
    private final IRepository<Category> categoryRepository;
    private final IRepository<Topic> topicRepository;

    @Autowired

    public CourseService(IRepository<Course> courseRepository, IRepository<Category> categoryRepository, IRepository<Topic> topicRepository) {
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
        this.topicRepository = topicRepository;
    }


    @Override
    public Course addCategoryInCourse(AddCategoryInCourseDto dto) {
        var category = getCategoryById(dto.idCategory());
        var course = getCourseById(dto.idCourse());

        category.getCourses().add(course);
        course.getCategories().add(category);

        courseRepository.save(course);
        categoryRepository.save(category);

        return course;
    }

    @Override
    public Boolean deleteCategoryInCourse(DeleteCategoryInCourseDto dto) {
        var category = getCategoryById(dto.idCategory());
        var course = getCourseById(dto.idCourse());

        boolean removedFromCategory = category.getCourses().remove(course);
        boolean removedFromCourse = course.getCategories().remove(category);

        if (!(removedFromCategory && removedFromCourse))
            return false;

        categoryRepository.save(category);
        courseRepository.save(course);
        return true;
    }

    @Override
    public Course createCourse(CreateCourseDto dto) {

        try {
            var course = new Course(dto.name(), getTopicById(dto.idTopic()), new ArrayList<>());
            return courseRepository.save(course);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create the course ", e);
        }
    }

    @Override
    public Boolean deleteCourse(DeleteCourseDto dto) {
        try {
            var course = getCourseById(dto.id());
            courseRepository.delete(course);
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    @Override
    public Course updateCourseName(UpdateCourseNameDto dto) {
        var course = getCourseById(dto.id());
        course.updateName(dto.newName());
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public <T extends Specification<Course>> List<Course> getAllCoursesBySpecification(T specification) {
        return courseRepository.findAll(specification);
    }

    @Override
    public Course getCourseByName(String name) {
        var specification = new CourseByNameSpecification(name);

        return courseRepository.findOne(specification)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with the name" + name));

    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id " + id));
    }

    private Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id " + id));
    }

    private Topic getTopicById(Long id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Topic not found with id " + id));

    }
}
