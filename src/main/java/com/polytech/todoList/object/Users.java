package com.polytech.todoList.object;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name="enabled")
    private Boolean enabled;

    @OneToMany
    @JoinColumn(name = "username")
    private List<Authority> list_auth;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getList_auth() {
        return list_auth;
    }

    public void setList_auth(List<Authority> list_auth) {
        this.list_auth = list_auth;
    }

    public Users() {}

    public Users(String usn, String passwd){
        this.username = usn;
        this.password = passwd;
        this.list_auth = new ArrayList<Authority>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + this.username + '\'' +
                '}';
    }
}
