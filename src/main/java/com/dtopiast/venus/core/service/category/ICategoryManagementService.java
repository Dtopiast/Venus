package com.dtopiast.venus.core.service.category;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.category.dto.CreateCategoryDto;
import com.dtopiast.venus.domain.category.dto.DeleteCategoryDto;
import com.dtopiast.venus.domain.category.dto.UpdateCategoryNameDto;
import com.dtopiast.venus.domain.category.model.Category;

public interface ICategoryManagementService extends MyService {
    Category createCategory(CreateCategoryDto dto);

    Boolean deleteCategory(DeleteCategoryDto dto);

    Category updateCategoryName(UpdateCategoryNameDto dto);
}

