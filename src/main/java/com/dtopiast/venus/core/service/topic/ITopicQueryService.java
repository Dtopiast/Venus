package com.dtopiast.venus.core.service.topic;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.response.model.Response;
import com.dtopiast.venus.domain.topic.model.Topic;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ITopicQueryService extends MyService {
    List<Topic> getAllTopic();

    <T extends Specification<Topic>> List<Topic> getAllTopicsBySpecification(T specification);

    Topic getTopicByName(String topicName);
    Topic getTopicByAuthor(Long idAuthor);

    Topic getTopicById(Long id);
}
