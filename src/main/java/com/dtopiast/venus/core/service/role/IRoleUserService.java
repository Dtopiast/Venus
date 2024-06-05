package com.dtopiast.venus.core.service.role;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.profile.dto.AddUserInProfileDto;
import com.dtopiast.venus.domain.profile.dto.DeleteUserInProfileDto;
import com.dtopiast.venus.domain.profile.model.Profile;
import com.dtopiast.venus.domain.role.dto.AddUserInRoleDto;
import com.dtopiast.venus.domain.role.dto.DeleteUserWithRoleDto;
import com.dtopiast.venus.domain.role.model.Role;

public interface IRoleUserService extends MyService {
    Role AddUserInRole(AddUserInRoleDto dto);
    Boolean deleteUserWithRole(DeleteUserWithRoleDto dto);
}
