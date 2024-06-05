package com.dtopiast.venus.domain.topic.dto;

import com.dtopiast.venus.domain.user.dto.UserDto;

public record CreateTopicDto(String title, String message,Long  idAuthor) {
}
