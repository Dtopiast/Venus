package com.dtopiast.venus.dto.course;

import com.dtopiast.venus.dto.topic.TopicDto;
import com.dtopiast.venus.model.Category;

import java.util.List;

public record CourseDto(String name, TopicDto topic, List<Category> categories) {
}
