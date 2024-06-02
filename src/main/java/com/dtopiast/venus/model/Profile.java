package com.dtopiast.venus.model;

import com.dtopiast.venus.model.base.MyModel;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a user profile in the system.
 */
@Table(name = "profile")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Profile extends MyModel {

    /**
     * The name of the profile.
     */
    private String name;

    /**
     * The users associated with the profile.
     */
    @ManyToMany
    private List<User> users;
}
