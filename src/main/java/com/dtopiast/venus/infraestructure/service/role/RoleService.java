package com.dtopiast.venus.infraestructure.service.role;

import com.dtopiast.venus.core.service.repository.IRepository;
import com.dtopiast.venus.core.service.role.IRoleService;
import com.dtopiast.venus.domain.role.dto.*;
import com.dtopiast.venus.domain.role.model.Role;
import com.dtopiast.venus.domain.role.specification.RoleByNameSpecification;
import com.dtopiast.venus.domain.user.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class RoleService implements IRoleService {
    private final IRepository<Role> roleRepository;
    private final IRepository<User> userRepository;

    @Autowired
    public RoleService(IRepository<Role> roleRepository, IRepository<User> userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public <T extends Specification<Role>> List<Role> getAllRolesBySpecification(T specification) {
        return roleRepository.findAll(specification);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id " + id));

    }

    @Override
    public Role getRoleByName(String name) {
        var specification = new RoleByNameSpecification(name);
        return roleRepository.findOne(specification)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with the name" + name));

    }

    @Override
    public Role addUserInRole(AddUserInRoleDto dto) {
        var user = getUserById(dto.idUser());
        var role = getRoleById(dto.idRole());
        user.getRoles().add(role);
        role.getUsers().add(user);

        roleRepository.save(role);
        userRepository.save(user);
        return role;
    }

    @Override
    public Boolean deleteUserWithRole(DeleteUserWithRoleDto dto) {
        var role = getRoleById(dto.idRole());
        var user = getUserById(dto.idUser());

        boolean removedFromRole = role.getUsers().remove(user);
        boolean removedFromUser = user.getRoles().remove(role);

        if (!(removedFromRole && removedFromUser))
            return false;

        roleRepository.save(role);
        userRepository.save(user);
        return true;
    }

    private User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    @Override
    public Role createRole(CreateRoleDto dto) {
        try {
            Role role = new Role(dto.name(), dto.type(), new ArrayList<>());
            return roleRepository.save(role);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create category ", e);
        }
    }

    @Override
    public Boolean deleteRole(DeleteRoleDto dto) {
        try {
            var role = getRoleById(dto.id());
            roleRepository.delete(role);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Role updateRoleName(UpdateRoleNameDto dto) {
        var role = getRoleById(dto.id());
        role.updateName(dto.newName());
        return roleRepository.save(role);
    }
}
