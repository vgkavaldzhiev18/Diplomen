package com.app.pizzashop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Table(name = "AppUser")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class AppUser extends BaseEntity implements UserDetails {


    public AppUser(String username,String firstName, String lastName, String email, AuthMethod method, String password, boolean isEnabled, List<Role> roles
    ,String authIdentifier) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.method = method;
        this.password = password;
        this.isEnabled = isEnabled;
        this.roles = roles;
        this.authIdentifier = authIdentifier;
    }


    @Column
    private String username;
    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column
    private String authIdentifier;


    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    private AuthMethod method;

    @Column
    private String password;

    @Column
    private boolean isEnabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
