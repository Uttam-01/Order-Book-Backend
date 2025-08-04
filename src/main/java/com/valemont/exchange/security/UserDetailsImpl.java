package com.valemont.exchange.security;

import com.valemont.exchange.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Use roles or permissions here if needed
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();  // map to DB field
    }

    @Override
    public String getUsername() {
        return user.getEmail();     // map to unique identifier (usually email or username)
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // customize as needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // customize as needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // customize as needed
    }

    @Override
    public boolean isEnabled() {
        return true;  // customize as needed
    }

    public User getUser() {
        return user;  // for accessing the original entity if needed
    }
}
