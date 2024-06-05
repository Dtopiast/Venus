package com.dtopiast.venus.core.service.topic;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.role.dto.CreateRoleDto;
import com.dtopiast.venus.domain.role.dto.DeleteRoleDto;
import com.dtopiast.venus.domain.role.dto.UpdateRoleNameDto;
import com.dtopiast.venus.domain.role.model.Role;
import com.dtopiast.venus.domain.topic.dto.*;
import com.dtopiast.venus.domain.topic.model.Topic;

public interface ITopicManagementService extends MyService {
    Topic createTopic(CreateTopicDto dto);

    Boolean deleteTopic(DeleteTopicDto dto);

    Topic updateTopicStatus(UpdateTopicStatusDto dto);
    Topic updateTopicMessage(UpdateTopicMessageDto dto);
    Topic updateTopicTitle(UpdateTopicTitleDto dto);
}
