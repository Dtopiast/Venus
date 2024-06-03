package com.dtopiast.venus.domain.topic.dto;

import com.dtopiast.venus.domain.user.dto.UserDto;

import java.time.LocalDate;
import java.util.List;

public record TopicDto(String title,
                       String message,
                       TopicStatus status,
                       LocalDate creationDate,
                       UserDto author,
                       List<Long> responses) {

}
