package com.dtopiast.venus.dto.topic;

import com.dtopiast.venus.dto.user.UserDto;

public record CreateTopicDto(String title, String message, UserDto author) {
}
