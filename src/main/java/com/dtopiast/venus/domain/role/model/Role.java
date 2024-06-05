package com.dtopiast.venus.domain.role.model;

import com.dtopiast.venus.domain.role.dto.RoleType;
import com.dtopiast.venus.domain.user.model.User;
import com.dtopiast.venus.domain.base.MyModel;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * Represents a role in the system.
 */
@Table(name = "role")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends MyModel {

    /**
     * The name of the role.
     */
    private String name;

    /**
     * The type of the role.
     */
    private RoleType type;

    /**
     * The users assigned to the role.
     */
    @ManyToMany
    private List<User> users;
    public Role updateName(String newName){
        this.name = newName;
        return this;
    }
}

