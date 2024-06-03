package com.dtopiast.venus.dto.role;

import com.dtopiast.venus.dto.user.UserDto;
import com.dtopiast.venus.model.RoleType;

import java.util.List;

public record RoleDto(String name, RoleType type, List<UserDto> usersWithRole) {
}
