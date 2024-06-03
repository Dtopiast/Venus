package com.dtopiast.venus.domain.response.dto;

import com.dtopiast.venus.domain.topic.dto.TopicDto;
import com.dtopiast.venus.domain.user.dto.UserDto;

import java.time.LocalDate;

public record ResponseDto(String message, String solution, LocalDate creationDate, UserDto author, TopicDto topic) {

}
