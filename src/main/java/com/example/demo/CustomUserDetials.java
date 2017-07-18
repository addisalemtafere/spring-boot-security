package com.example.demo;

import com.example.demo.entities.Role;
import com.example.demo.entities.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by addis on 7/18/17.
 */
public class CustomUserDetials implements UserDetails {

    private String username;
    private String password;

    Collection<? extends GrantedAuthority> authorities;


    public CustomUserDetials(Users byUserName) {
        this.username = byUserName.getUserName();
        this.password = byUserName.getPassword();

        List<GrantedAuthority> auths = new ArrayList<>();
        for (Role role : byUserName.getRoles()) {
            auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));

            this.authorities = auths;
        }
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
        return true;
    }
}
