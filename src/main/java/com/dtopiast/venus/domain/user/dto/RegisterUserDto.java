package com.dtopiast.venus.domain.user.dto;

import com.dtopiast.venus.domain.role.model.Role;

import java.util.List;

public record RegisterUserDto(String name, String password, String email) {
}
