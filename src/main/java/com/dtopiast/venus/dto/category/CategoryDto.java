package com.dtopiast.venus.dto.category;

import com.dtopiast.venus.dto.user.UserDto;

import java.util.List;

public record CategoryDto(Long id, String name, List<UserDto> users) {

}
