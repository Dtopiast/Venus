package com.dtopiast.venus.dto.user;

import com.dtopiast.venus.dto.response.ResponseDto;

import java.util.List;

public record UserDto(List<ResponseDto> responses, String name, String email, List<Long> profiles, List<Long> roles) {

}
