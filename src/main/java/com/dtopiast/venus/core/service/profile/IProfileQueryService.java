package com.dtopiast.venus.core.service.profile;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.profile.model.Profile;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface IProfileQueryService extends MyService {
    List<Profile> getAllProfiles();

    <T extends Specification<Profile>> List<Profile> getAllProfilesBySpecification(T specification);

    Profile getProfileByName(String name);

    Profile getProfileById(Long id);
}
