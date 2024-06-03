package com.dtopiast.venus.core.service.category;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.category.dto.AddCourseInCategoryDto;
import com.dtopiast.venus.domain.category.dto.DeleteCourseInCategoryDto;
import com.dtopiast.venus.domain.category.model.Category;

public interface ICategoryCourseService extends MyService {
    Category addCourseInCategory(AddCourseInCategoryDto dto);

    Boolean deleteCourseInCategory(DeleteCourseInCategoryDto dto);
}