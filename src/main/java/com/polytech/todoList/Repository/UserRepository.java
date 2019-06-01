package com.polytech.todoList.Repository;

import com.polytech.todoList.object.Authority;
import com.polytech.todoList.object.Users;

public interface UserRepository {

    boolean isUsernameDefined(String username);

    void send_registration(Users user, Authority auth);

    void modify_Password();
}
