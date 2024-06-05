package com.dtopiast.venus.core.service.user;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.topic.model.Topic;
import com.dtopiast.venus.domain.user.model.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface IUserQueryService  extends MyService {
    List<User> getAllTopic();

    <T extends Specification<User>> List<User> getAllUsersBySpecification(T specification);

    User getUserByName(String userName);
    User getUserById(Long id);


}
