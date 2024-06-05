package com.dtopiast.venus.core.service.user;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.user.dto.DeleteUserDto;
import com.dtopiast.venus.domain.user.dto.RegisterUserDto;
import com.dtopiast.venus.domain.user.dto.UpdateUserEmailDto;
import com.dtopiast.venus.domain.user.dto.UpdateUserNameDto;
import com.dtopiast.venus.domain.user.model.User;

public interface IUserManagementService extends MyService {
    User registerUser(RegisterUserDto dto);
    Boolean deleteUser(DeleteUserDto dto);

    User updateUserEmail(UpdateUserEmailDto dto);
    User updateUserName(UpdateUserNameDto dto);
}
