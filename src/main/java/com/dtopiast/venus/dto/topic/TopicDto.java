package com.dtopiast.venus.dto.topic;

import com.dtopiast.venus.dto.user.UserDto;
import com.dtopiast.venus.model.TopicStatus;

import java.time.LocalDate;
import java.util.List;

public record TopicDto(String title,
                       String message,
                       TopicStatus status,
                       LocalDate creationDate,
                       UserDto author,
                       List<Long> responses) {

}
