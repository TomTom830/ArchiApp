package com.polytech.todoList.business;

import com.polytech.todoList.Repository.UserRepository;
import com.polytech.todoList.object.Authority;
import com.polytech.todoList.object.Users;

public class RegisterServiceImpl implements RegisterService {

    private UserRepository userRepository;

    public RegisterServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(Users usr, Authority auth) {
        userRepository.send_registration(usr,auth);

    }

    @Override
    public boolean isNameDefined(String usrn) {
        return userRepository.isUsernameDefined(usrn);
    }

    @Override
    public void change_Password() {
        userRepository.modify_Password();
    }
}
