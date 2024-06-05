package com.dtopiast.venus.core.service.category;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.base.MySpecification;
import com.dtopiast.venus.domain.category.model.Category;

import java.util.List;

public interface ICategoryQueryService extends MyService {
    List<Category> getAllCategories();

    <T extends MySpecification<Category>> List<Category> getAllCategoriesBySpecification(T specification);

    Category getCategoryByName(String name);

    Category getCategoryById(Long id);
}
