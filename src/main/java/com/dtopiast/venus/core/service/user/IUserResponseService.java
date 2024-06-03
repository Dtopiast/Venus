package com.dtopiast.venus.core.service.user;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.category.dto.AddCourseInCategoryDto;
import com.dtopiast.venus.domain.category.dto.DeleteCourseInCategoryDto;
import com.dtopiast.venus.domain.category.model.Category;
import com.dtopiast.venus.domain.user.dto.AddResponseInUserDto;
import com.dtopiast.venus.domain.user.dto.DeleteProfileInUserDto;
import com.dtopiast.venus.domain.user.dto.DeleteResponseInUserDto;
import com.dtopiast.venus.domain.user.model.User;

public interface IUserResponseService extends MyService {
    User addResponseInUser(AddResponseInUserDto dto);

    Boolean deleteResponseInUser(DeleteResponseInUserDto dto);
}
