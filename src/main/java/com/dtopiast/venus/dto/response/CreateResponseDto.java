package com.dtopiast.venus.dto.response;

import com.dtopiast.venus.dto.topic.TopicDto;
import com.dtopiast.venus.dto.user.UserDto;

public record CreateResponseDto(String message, UserDto author, TopicDto topic) {
}
