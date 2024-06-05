package com.dtopiast.venus.infraestructure.service.category;

import com.dtopiast.venus.core.service.category.ICategoryService;
import com.dtopiast.venus.core.service.repository.IRepository;
import com.dtopiast.venus.domain.base.MySpecification;
import com.dtopiast.venus.domain.category.dto.*;
import com.dtopiast.venus.domain.category.model.Category;
import com.dtopiast.venus.domain.category.specification.CategoryByNameSpecification;
import com.dtopiast.venus.domain.course.model.Course;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService {
    private final IRepository<Category> categoryRepository;
    private final IRepository<Course> courseRepository;

    @Autowired
    public CategoryService(IRepository<Category> categoryRepository, IRepository<Course> courseRepository) {
        this.categoryRepository = categoryRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Category addCourseInCategory(AddCourseInCategoryDto dto) {
        var category = getCategoryById(dto.idCategory());
        var course = getCourseById(dto.idCourse());
        category.getCourses().add(course);
        course.getCategories().add(category);

        courseRepository.save(course);
        categoryRepository.save(category);

        return category;
    }

    @Override
    public Boolean deleteCourseInCategory(DeleteCourseInCategoryDto dto) {
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
    public Category createCategory(CreateCategoryDto dto) {

        try {
            Category category = new Category(new ArrayList<>(), dto.name());
            return categoryRepository.save(category);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create category ", e);
        }
    }

    @Override
    public Boolean deleteCategory(DeleteCategoryDto dto) {

        try {
            var category = getCategoryById(dto.id());
            categoryRepository.delete(category);
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    @Override
    public Category updateCategoryName(UpdateCategoryNameDto dto) {
        var category = getCategoryById(dto.id());
        category.updateName(dto.newName());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public <T extends MySpecification<Category>> List<Category> getAllCategoriesBySpecification(T specification) {
        return categoryRepository.findAll(specification);

    }

    @Override
    public Category getCategoryByName(String name) {
        var specification = new CategoryByNameSpecification(name);
        return categoryRepository.findOne(specification)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with the name" + name));
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id " + id));
    }

    private Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id " + id));
    }
}
