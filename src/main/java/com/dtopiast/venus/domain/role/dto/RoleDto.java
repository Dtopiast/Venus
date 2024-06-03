package com.dtopiast.venus.domain.role.dto;

import com.dtopiast.venus.domain.user.dto.UserDto;

import java.util.List;

public record RoleDto(String name, RoleType type, List<UserDto> usersWithRole) {
}
