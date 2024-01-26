package com.example.demo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;

@Entity
public class User implements UserDetails {

    @Id
    private Long id;
    private String username;
    private String password;

    // other fields and methods

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // return the authorities/roles for this user
        // you may implement this method based on your application's logic
        return null;
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
        return true; // implement logic for account expiration
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // implement logic for account locking
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // implement logic for credentials expiration
    }

    @Override
    public boolean isEnabled() {
        return true; // implement logic for enabling/disabling accounts
    }

    // getters and setters for other fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
