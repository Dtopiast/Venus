package com.dtopiast.venus.core.service.profile;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.profile.dto.AddUserInProfileDto;
import com.dtopiast.venus.domain.profile.dto.DeleteUserInProfileDto;
import com.dtopiast.venus.domain.profile.model.Profile;
import com.dtopiast.venus.domain.user.dto.AddProfileInUserDto;

public interface IProfileUserService extends MyService {
    Profile AddUserInProfileDto(AddUserInProfileDto dto);

    Boolean deleteUserInProfileDto(DeleteUserInProfileDto dto);
}
