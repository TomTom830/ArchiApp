package com.polytech.todoList.api;

import com.polytech.todoList.exception.ExceptionUsernameAlreadyUsed;
import com.polytech.todoList.object.Authority;
import com.polytech.todoList.business.RegisterService;
import com.polytech.todoList.object.Response;
import com.polytech.todoList.object.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegistrationController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public Response register(@RequestBody Users usr) {

        Response res;

        try {
            if (registerService.isNameDefined(usr.getUsername()))
                throw new ExceptionUsernameAlreadyUsed(usr.getUsername());
            Authority auth = new Authority(usr.getUsername(), "ADMIN");
            usr.setPassword(new BCryptPasswordEncoder().encode(usr.getPassword()));
            usr.setEnabled(true);
            registerService.register(usr,auth);
            res=new Response("OK");
        }catch(ExceptionUsernameAlreadyUsed e){
            res=new Response(e.toString() );
        }
        return res;
    }

    @PostMapping("/modifyPassword")
    public void register(){
        registerService.change_Password();
    }
}
