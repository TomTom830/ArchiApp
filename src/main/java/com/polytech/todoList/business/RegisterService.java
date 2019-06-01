package com.polytech.todoList.business;

import com.polytech.todoList.object.Authority;
import com.polytech.todoList.object.Users;

public interface RegisterService {
    void register(Users usr, Authority auth);

    boolean isNameDefined(String usrn);

    void change_Password();
}
