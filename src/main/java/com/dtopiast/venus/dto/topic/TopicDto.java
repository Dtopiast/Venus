package com.dtopiast.venus.dto.topic;

import com.dtopiast.venus.model.TopicStatus;
import com.dtopiast.venus.model.User;

import java.time.LocalDate;
import java.util.List;

public record TopicDto(String title, String message, TopicStatus status, LocalDate creationDate, User author,
                       List<Long> responses) {

}
