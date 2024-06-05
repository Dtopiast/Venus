package com.dtopiast.venus.core.service.role;

import com.dtopiast.venus.core.service.base.MyService;
import com.dtopiast.venus.domain.response.model.Response;
import com.dtopiast.venus.domain.role.model.Role;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface IRoleQueryService extends MyService {
    List<Role> getAllRoles();
    <T extends Specification<Role>> List<Role> getAllRolesBySpecification(T specification);
    Role getRoleById(Long id);
    Role getRoleByName(String name);
}
