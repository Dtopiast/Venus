package com.dtopiast.venus.domain.course.dto;

import com.dtopiast.venus.domain.topic.dto.TopicDto;
import com.dtopiast.venus.domain.category.model.Category;

import java.util.List;

public record CourseDto(String name, TopicDto topic, List<Category> categories) {
}
