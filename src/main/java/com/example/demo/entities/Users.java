package com.example.demo.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by addis on 7/18/17.
 */
@Entity
public class Users {

    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users", fetch = FetchType.EAGER)
    private List<Role> roles;


    public Users() {
    }

    public Users(String userName, String password, List<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
