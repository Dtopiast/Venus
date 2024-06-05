package com.dtopiast.venus.infraestructure.service.user;

import com.dtopiast.venus.core.service.repository.IRepository;
import com.dtopiast.venus.core.service.user.IUserService;
import com.dtopiast.venus.domain.profile.model.Profile;
import com.dtopiast.venus.domain.response.model.Response;
import com.dtopiast.venus.domain.role.model.Role;
import com.dtopiast.venus.domain.topic.model.Topic;
import com.dtopiast.venus.domain.user.dto.*;
import com.dtopiast.venus.domain.user.model.User;
import com.dtopiast.venus.domain.user.specification.UserByNameSpecification;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    private final IRepository<User> userRepository;
    private final IRepository<Profile> profileRepository;
    private final IRepository<Role> roleRepository;
    private final IRepository<Response> responseRepository;

    @Autowired

    public UserService(IRepository<User> userRepository, IRepository<Profile> profileRepository, IRepository<Role> roleRepository, IRepository<Response> responseRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.roleRepository = roleRepository;
        this.responseRepository = responseRepository;
    }


    @Override
    public User registerUser(RegisterUserDto dto) {
        try {
            User user = new User(null, new ArrayList<Response>(), dto.name(), dto.email(), dto.password(), new ArrayList<Profile>(), new ArrayList<Role>(), new ArrayList<Topic>());
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Failed to user register ", e);
        }
    }

    @Override
    public Boolean deleteUser(DeleteUserDto dto) {
        try {
            var user = getUserById(dto.id());
            userRepository.delete(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User updateUserEmail(UpdateUserEmailDto dto) {
        var user = getUserById(dto.id());
        user.updateEmail(dto.newEmail());
        return userRepository.save(user);
    }

    @Override
    public User updateUserName(UpdateUserNameDto dto) {
        var user = getUserById(dto.idUser());
        user.updateEmail(dto.newName());
        return userRepository.save(user);
    }

    @Override
    public User addProfileInUser(AddProfileInUserDto dto) {
        var profile = getProfileById(dto.idProfile());
        var user = getUserById(dto.idUser());

        user.getProfiles().add(profile);
        profile.getUsers().add(user);

        userRepository.save(user);
        profileRepository.save(profile);


        return user;
    }

    @Override
    public Boolean deleteProfileInUser(DeleteProfileInUserDto dto) {
        Profile profile = getProfileById(dto.idProfile());
        var user = getUserById(dto.idUser());

        boolean removedFromProfile = profile.getUsers().remove(user);
        boolean removedFromUser = user.getProfiles().remove(profile);

        if (!(removedFromProfile && removedFromUser))
            return false;

        profileRepository.save(profile);
        userRepository.save(user);
        return true;
    }

    private Profile getProfileById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profile not found with id " + id));

    }

    @Override
    public List<User> getAllTopic() {
        return userRepository.findAll();
    }

    @Override
    public <T extends Specification<User>> List<User> getAllUsersBySpecification(T specification) {
        return userRepository.findAll(specification);
    }

    @Override
    public User getUserByName(String userName) {
        var specification = new UserByNameSpecification(userName);
        return userRepository.findOne(specification)
                .orElseThrow(() -> new EntityNotFoundException("User not found with the name" + userName));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));

    }

    @Override
    public User addResponseInUser(AddResponseInUserDto dto) {
        Response response = getResponseById(dto.idResponse());
        var user = getUserById(dto.idUser());

        user.getResponses().add(response);
        response.setAuthor(user);

        userRepository.save(user);
        responseRepository.save(response);

        return user;
    }

    private Response getResponseById(Long id) {
        return responseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Response not found with the id" + id));

    }

    @Override
    public Boolean deleteResponseInUser(DeleteResponseInUserDto dto) {
        var response = getResponseById(dto.idResponse());
        var user = getUserById(dto.idUser());

        boolean removedFromUser = user.getResponses().remove(response);

        if (!removedFromUser) {
            return false;
        }

        responseRepository.delete(response);

        userRepository.save(user);

        return true;
    }
}

