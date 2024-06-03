package com.dtopiast.venus.dto.role;

import com.dtopiast.venus.model.RoleType;

public record CreateRoleDto(String name, RoleType type) {
}
