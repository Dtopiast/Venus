package com.dtopiast.venus.domain.response.dto;

import com.dtopiast.venus.domain.topic.dto.TopicDto;
import com.dtopiast.venus.domain.user.dto.UserDto;

public record CreateResponseDto(String message, Long idAuthor, Long idTopic) {
}
