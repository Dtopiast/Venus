package com.dtopiast.venus.infraestructure.service.profile;

import com.dtopiast.venus.core.service.profile.IProfileService;
import com.dtopiast.venus.core.service.repository.IRepository;
import com.dtopiast.venus.domain.profile.dto.*;
import com.dtopiast.venus.domain.profile.model.Profile;
import com.dtopiast.venus.domain.profile.specification.ProfileByNameSpecification;
import com.dtopiast.venus.domain.user.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProfileService implements IProfileService {
    private final IRepository<Profile> profileRepository;
    private final IRepository<User> userRepository;

    @Autowired

    public ProfileService(IRepository<Profile> profileRepository, IRepository<User> userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Profile createProfileDto(CreateProfileDto dto) {
        try {
            Profile profile = new Profile(dto.name(), new ArrayList<>());
            return profileRepository.save(profile);

        } catch (Exception e) {
            throw new RuntimeException("Failed to create profile ", e);
        }
    }

    @Override
    public Boolean deleteProfile(DeleteProfileDto dto) {
        try {
            var profile = getProfileById(dto.id());
            profileRepository.delete(profile);
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    @Override
    public Profile updateProfileName(UpdateProfileNameDto dto) {
        var profile = getProfileById(dto.id());
        profile.updateName(dto.newName());

        return profileRepository.save(profile);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public <T extends Specification<Profile>> List<Profile> getAllProfilesBySpecification(T specification) {
        return profileRepository.findAll(specification);
    }

    @Override
    public Profile getProfileByName(String name) {
        var specification = new ProfileByNameSpecification(name);
        return profileRepository.findOne(specification)
                .orElseThrow(() -> new EntityNotFoundException("Profile not found with the name" + name));
    }

    @Override
    public Profile getProfileById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profile not found with id " + id));
    }

    @Override
    public Profile AddUserInProfileDto(AddUserInProfileDto dto) {
        var profile = getProfileById(dto.idProfile());
        var user = getUserById(dto.idUser());

        profile.getUsers().add(user);
        user.getProfiles().add(profile);

        profileRepository.save(profile);
        userRepository.save(user);

        return profile;
    }

    private User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with the id" + id));
    }

    @Override
    public Boolean deleteUserInProfileDto(DeleteUserInProfileDto dto) {
        var profile = getProfileById(dto.idProfile());
        var user = getUserById(dto.idUser());

        boolean removedFromUser = profile.getUsers().remove(user);
        boolean removedFromProfile = user.getProfiles().remove(profile);

        if (!(removedFromProfile && removedFromUser))
            return false;

        profileRepository.save(profile);
        userRepository.save(user);

        return true;
    }
}
