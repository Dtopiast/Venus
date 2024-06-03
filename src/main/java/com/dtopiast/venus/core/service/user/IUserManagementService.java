package com.dtopiast.venus.core.service.user;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.role.model.Role;
import com.dtopiast.venus.domain.topic.dto.*;
import com.dtopiast.venus.domain.topic.model.Topic;
import com.dtopiast.venus.domain.user.dto.DeleteUserDto;
import com.dtopiast.venus.domain.user.dto.RegisterUserDto;
import com.dtopiast.venus.domain.user.dto.UpdateUserEmailDto;
import com.dtopiast.venus.domain.user.dto.UpdateUserNameDto;
import com.dtopiast.venus.domain.user.model.User;

public interface IUserManagementService extends MyService {
    User createUser(RegisterUserDto dto);
    Boolean deleteUser(DeleteUserDto dto);

    User updateUserEmail(UpdateUserEmailDto dto);
    User updateUserName(UpdateUserNameDto dto);
}
