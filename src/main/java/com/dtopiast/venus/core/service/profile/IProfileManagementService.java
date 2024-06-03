package com.dtopiast.venus.core.service.profile;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.profile.dto.CreateProfileDto;
import com.dtopiast.venus.domain.profile.dto.DeleteProfileDto;
import com.dtopiast.venus.domain.profile.dto.UpdateProfileNameDto;
import com.dtopiast.venus.domain.profile.model.Profile;

public interface IProfileManagementService extends MyService {
    Profile createProfileDto(CreateProfileDto dto);

    Boolean deleteProfile(DeleteProfileDto dto);

    Profile updateProfileName(UpdateProfileNameDto dto);
}
