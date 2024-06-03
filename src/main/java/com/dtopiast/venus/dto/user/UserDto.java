package com.dtopiast.venus.dto.user;

import java.util.List;

public record UserDto(List<Long> responses, String name, String email, List<Long> profiles, List<Long> roles) {

}
