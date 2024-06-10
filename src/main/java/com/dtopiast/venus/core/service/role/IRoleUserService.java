package com.dtopiast.venus.core.service.role;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.role.dto.AddUserInRoleDto;
import com.dtopiast.venus.domain.role.dto.DeleteUserWithRoleDto;
import com.dtopiast.venus.domain.role.model.Role;

public interface IRoleUserService extends MyService {
    Role addUserInRole(AddUserInRoleDto dto);
    Boolean deleteUserWithRole(DeleteUserWithRoleDto dto);
}
