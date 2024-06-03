package com.dtopiast.venus.domain.category.dto;

import com.dtopiast.venus.domain.user.dto.UserDto;

import java.util.List;

public record CategoryDto(Long id, String name, List<UserDto> users) {

}
