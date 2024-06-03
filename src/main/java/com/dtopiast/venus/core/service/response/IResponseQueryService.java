package com.dtopiast.venus.core.service.response;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.profile.model.Profile;
import com.dtopiast.venus.domain.response.model.Response;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface IResponseQueryService extends MyService {
    List<Response> getAllResponse();

    <T extends Specification<Response>> List<Response> getAllResponsesBySpecification(T specification);

    Response getResponseByTopic(String topicName);

    Response getResponseById(Long id);
}
