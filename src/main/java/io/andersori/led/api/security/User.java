package io.andersori.led.api.security;

import java.util.Arrays;
import java.util.List;

import io.andersori.led.api.entity.RoleLed;

public class User {

    private String username;
    private String password;
    private List<RoleLed> roles = Arrays.asList(RoleLed.NONE);

    public User() {
        
    }

    public User(String username, String password, List<RoleLed> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleLed> getRoles() {
        return this.roles;
    }

    public void setRoles(List<RoleLed> roles) {
        this.roles = roles;
    }

}