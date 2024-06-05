package com.dtopiast.venus.domain.user.model;

import com.dtopiast.venus.domain.profile.model.Profile;
import com.dtopiast.venus.domain.response.model.Response;
import com.dtopiast.venus.domain.role.model.Role;
import com.dtopiast.venus.domain.topic.model.Topic;
import com.dtopiast.venus.domain.base.MyModel;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Represents a user in the system.
 */
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends MyModel implements UserDetails {

    /**
     * The id of the user.
     */
    private Long id;
    /**
     * The responses created by the user.
     */
    @OneToMany
    private List<Response> responses;
    /**
     * The name of the user.
     */
    @Column(unique = true)
    private String name;
    /**
     * The email of the user.
     */
    private String email;
    /**
     * The password of the user.
     */
    private String password;
    /**
     * The profiles associated with the user.
     */
    @ManyToMany
    private List<Profile> profiles;
    /**
     * The roles assigned to the user.
     */
    @ManyToMany
    private List<Role> roles;
    /**
     * The topics created by the user.
     */
    @OneToMany
    private List<Topic> topics;

    /**
     * Returns the authorities granted to the user.
     *
     * @return A collection of granted authorities.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    /**
     * Returns the password of the user.
     *
     * @return The password.
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the username of the user.
     *
     * @return The username.
     */
    @Override
    public String getUsername() {
        return name;
    }

    public User updateEmail(String newEmail) {
        this.email=newEmail;
        return this;
    }
    public User updatePassword(String password) {
        this.password = password;
        return this;
    }
}
