package com.dtopiast.venus.core.service.course;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.course.dto.AddCategoryInCourseDto;
import com.dtopiast.venus.domain.course.dto.DeleteCategoryInCourseDto;
import com.dtopiast.venus.domain.course.model.Course;

public interface ICourseCategoryService extends MyService {
    Course addCategoryInCourse(AddCategoryInCourseDto dto);

    Boolean deleteCategoryInCourse(DeleteCategoryInCourseDto dto);
}