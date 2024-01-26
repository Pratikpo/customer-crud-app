package com.example.demo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.Table;
import java.util.Collection;

@Component
@Table(name = "users")
public class UserDetailsImpl implements UserDetails {

    private Long id;
    private String username;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl() {
        // default constructor
    }

    public UserDetailsImpl(Long id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        return true; // You may implement logic for account expiration
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // You may implement logic for account locking
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // You may implement logic for credentials expiration
    }

    @Override
    public boolean isEnabled() {
        return true; // You may implement logic for enabling/disabling accounts
    }
    public Long getId() {
        return id;
    }

    public static UserDetailsImpl build(User user) {
        // construct UserDetailsImpl from your custom User entity
        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                // map authorities/roles here
                user.getAuthorities()
        );
    }
}
