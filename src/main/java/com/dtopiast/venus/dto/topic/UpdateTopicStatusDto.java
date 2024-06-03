package com.dtopiast.venus.dto.topic;

import com.dtopiast.venus.model.TopicStatus;

public record UpdateTopicStatusDto(Long id, TopicStatus newName) {
}
