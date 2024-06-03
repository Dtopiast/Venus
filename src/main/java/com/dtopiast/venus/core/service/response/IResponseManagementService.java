package com.dtopiast.venus.core.service.response;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.profile.dto.CreateProfileDto;
import com.dtopiast.venus.domain.profile.dto.DeleteProfileDto;
import com.dtopiast.venus.domain.profile.dto.UpdateProfileNameDto;
import com.dtopiast.venus.domain.profile.model.Profile;
import com.dtopiast.venus.domain.response.dto.CreateResponseDto;
import com.dtopiast.venus.domain.response.dto.DeleteResponseDto;
import com.dtopiast.venus.domain.response.dto.UpdateResponseMessageDto;
import com.dtopiast.venus.domain.response.dto.UpdateResponseSolutionDto;
import com.dtopiast.venus.domain.response.model.Response;

public interface IResponseManagementService extends MyService {
    Response createResponse(CreateResponseDto dto);
    Boolean deleteResponse(DeleteResponseDto dto);
    Response updateResponseMessage(UpdateResponseMessageDto dto);
    Response updateResponseSolution(UpdateResponseSolutionDto dto);
}
