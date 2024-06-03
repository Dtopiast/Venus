package com.dtopiast.venus.infraestructure.service.course;

import com.dtopiast.venus.core.service.category.ICategoryService;
import com.dtopiast.venus.domain.base.MySpecification;
import com.dtopiast.venus.domain.category.dto.*;
import com.dtopiast.venus.domain.category.model.Category;

import java.util.List;

public class CourseService  implements ICategoryService {
    @Override
    public Category addCourseInCategory(AddCourseInCategoryDto dto) {
        return null;
    }

    @Override
    public Boolean deleteCourseInCategory(DeleteCourseInCategoryDto dto) {
        return null;
    }

    @Override
    public Category createCategory(CreateCategoryDto dto) {
        return null;
    }

    @Override
    public Boolean deleteCategory(DeleteCategoryDto dto) {
        return null;
    }

    @Override
    public Category updateCategoryName(UpdateCategoryNameDto dto) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public <T extends MySpecification<Category>> List<Category> getAllCategoriesBySpecification(T specification) {
        return null;
    }

    @Override
    public Category getCategoryByName(String name) {
        return null;
    }

    @Override
    public Category getCategoryById(Long id) {
        return null;
    }
}
