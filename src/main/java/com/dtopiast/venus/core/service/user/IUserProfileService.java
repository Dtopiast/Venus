package com.dtopiast.venus.core.service.user;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.user.dto.AddProfileInUserDto;
import com.dtopiast.venus.domain.user.dto.DeleteProfileInUserDto;
import com.dtopiast.venus.domain.user.model.User;

public interface IUserProfileService extends MyService {
    User addProfileInUser(AddProfileInUserDto dto);
    Boolean deleteProfileInUser(DeleteProfileInUserDto dto);
}
