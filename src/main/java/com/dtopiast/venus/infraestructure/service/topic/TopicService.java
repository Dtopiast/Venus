package com.dtopiast.venus.infraestructure.service.topic;

import com.dtopiast.venus.core.service.repository.IRepository;
import com.dtopiast.venus.core.service.topic.ITopicService;
import com.dtopiast.venus.domain.response.model.Response;
import com.dtopiast.venus.domain.topic.dto.*;
import com.dtopiast.venus.domain.topic.model.Topic;
import com.dtopiast.venus.domain.topic.specification.TopicByTitleSpecification;
import com.dtopiast.venus.domain.topic.specification.TopicsByAuthorSpecification;
import com.dtopiast.venus.domain.user.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TopicService implements ITopicService {
    private final IRepository<Topic> topicRepository;
    private final IRepository<User> userRepository;

    @Autowired

    public TopicService(IRepository<Topic> topicRepository, IRepository<User> userRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Topic createTopic(CreateTopicDto dto) {
        var author = userRepository.findById(dto.idAuthor())
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id " + dto.idAuthor()));
        try {
            var topic = new Topic(dto.title(), dto.message(), TopicStatus.OPEN, LocalDate.now(), author, false, new ArrayList<Response>());
            return topicRepository.save(topic);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create topic ", e);
        }
    }

    @Override
    public Boolean deleteTopic(DeleteTopicDto dto) {
        try {
            var topic = getTopicById(dto.id());
            topicRepository.delete(topic);
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    @Override
    public Topic updateTopicStatus(UpdateTopicStatusDto dto) {
        var topic = getTopicById(dto.id());
        topic.updateStatus(dto.newStatus());
        return topicRepository.save(topic);
    }

    @Override
    public Topic updateTopicMessage(UpdateTopicMessageDto dto) {
        var topic = getTopicById(dto.id());
        topic.updateMessage(dto.newMessage());
        return topicRepository.save(topic);
    }

    @Override
    public Topic updateTopicTitle(UpdateTopicTitleDto dto) {
        var topic = getTopicById(dto.id());
        topic.updateTitle(dto.newTitle());
        return topicRepository.save(topic);
    }

    @Override
    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    @Override
    public <T extends Specification<Topic>> List<Topic> getAllTopicsBySpecification(T specification) {
        return topicRepository.findAll(specification);
    }

    @Override
    public Topic getTopicByTitle(String title) {
        var specification = new TopicByTitleSpecification(title);
        return topicRepository.findOne(specification)
                .orElseThrow(() -> new EntityNotFoundException("Topic not found with the title" + title));
    }

    @Override
    public List<Topic> getTopicsByAuthorName(String authorName) {
        var specification = new TopicsByAuthorSpecification(authorName);
        return topicRepository.findAll(specification);
    }

    @Override
    public Topic getTopicById(Long id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Topic not found with id " + id));

    }
}
