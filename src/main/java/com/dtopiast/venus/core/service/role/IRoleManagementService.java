package com.dtopiast.venus.core.service.role;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.response.dto.CreateResponseDto;
import com.dtopiast.venus.domain.response.dto.DeleteResponseDto;
import com.dtopiast.venus.domain.response.dto.UpdateResponseMessageDto;
import com.dtopiast.venus.domain.response.dto.UpdateResponseSolutionDto;
import com.dtopiast.venus.domain.response.model.Response;
import com.dtopiast.venus.domain.role.dto.CreateRoleDto;
import com.dtopiast.venus.domain.role.dto.DeleteRoleDto;
import com.dtopiast.venus.domain.role.dto.UpdateRoleNameDto;
import com.dtopiast.venus.domain.role.model.Role;

public interface IRoleManagementService extends MyService {
    Role createRole(CreateRoleDto dto);

    Boolean deleteRole(DeleteRoleDto dto);

    Role updateRoleName(UpdateRoleNameDto dto);
}
