package com.dtopiast.venus.dto.response;

import com.dtopiast.venus.dto.topic.TopicDto;
import com.dtopiast.venus.dto.user.UserDto;

import java.time.LocalDate;

public record ResponseDto(String message, String solution, LocalDate creationDate, UserDto author, TopicDto topic) {

}
