package com.dtopiast.venus.infraestructure.service.response;

import com.dtopiast.venus.core.service.repository.IRepository;
import com.dtopiast.venus.core.service.response.IResponseService;
import com.dtopiast.venus.domain.response.dto.CreateResponseDto;
import com.dtopiast.venus.domain.response.dto.DeleteResponseDto;
import com.dtopiast.venus.domain.response.dto.UpdateResponseMessageDto;
import com.dtopiast.venus.domain.response.dto.UpdateResponseSolutionDto;
import com.dtopiast.venus.domain.response.model.Response;
import com.dtopiast.venus.domain.topic.model.Topic;
import com.dtopiast.venus.domain.topic.specification.TopicByTitleSpecification;
import com.dtopiast.venus.domain.user.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;

public class ResponseService implements IResponseService {
    private final IRepository<Response> responseRepository;
    private final IRepository<Topic> topicRepository;
    private final IRepository<User> userRepository;

    @Autowired
    public ResponseService(IRepository<Response> responseRepository, IRepository<Topic> topicRepository, IRepository<User> userRepository) {
        this.responseRepository = responseRepository;
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Response createResponse(CreateResponseDto dto) {

        var author = getUserById(dto.idAuthor());
        var topic = getTopicById(dto.idTopic());

        Response response = new Response(dto.message(), null, LocalDate.now(), author, topic, false);
        return null;
    }

    @Override
    public Boolean deleteResponse(DeleteResponseDto dto) {
        try {
            var response = getResponseById(dto.id());
            responseRepository.delete(response);
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    @Override
    public Response updateResponseMessage(UpdateResponseMessageDto dto) {
        var response = getResponseById(dto.id());
        response.updateMessage(dto.newMessage());
        return responseRepository.save(response);
    }

    @Override
    public Response updateResponseSolution(UpdateResponseSolutionDto dto) {
        var response = getResponseById(dto.id());
        response.updateSolution(dto.newSolution());
        return responseRepository.save(response);
    }

    @Override
    public List<Response> getAllResponse() {
        return responseRepository.findAll();
    }

    @Override
    public <T extends Specification<Response>> List<Response> getAllResponsesBySpecification(T specification) {
        return responseRepository.findAll(specification);
    }

    @Override
    public Response getResponseByTopic(String topicTitle) {
        var specification = new TopicByTitleSpecification(topicTitle);
        var topic = topicRepository.findOne(specification)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with the name"));
        return topic.getResponses().getFirst();
    }

    @Override
    public Response getResponseById(Long id) {
        return responseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Response not found with id " + id));

    }

    @Override
    public Page<Response> getAllResponse(Pageable pageable) {
        return responseRepository.findAll(pageable);
    }

    private User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    private Topic getTopicById(Long id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Topic not found with id " + id));
    }

}
