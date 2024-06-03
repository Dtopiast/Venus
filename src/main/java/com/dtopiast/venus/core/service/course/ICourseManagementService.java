package com.dtopiast.venus.core.service.course;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.course.dto.CreateCourseDto;
import com.dtopiast.venus.domain.course.dto.DeleteCourseDto;
import com.dtopiast.venus.domain.course.dto.UpdateCourseNameDto;
import com.dtopiast.venus.domain.course.model.Course;

public interface ICourseManagementService extends MyService {
    Course createCourse(CreateCourseDto dto);

    Boolean deleteCourse(DeleteCourseDto dto);

    Course updateCourseName(UpdateCourseNameDto dto);
}
