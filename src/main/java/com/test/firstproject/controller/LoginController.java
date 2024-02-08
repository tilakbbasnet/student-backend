package com.test.firstproject.controller;

import com.test.firstproject.model.LoginDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    //URL: http://localhost:8080/login
    @PostMapping("/login")
    public String login(@RequestBody LoginDetails login){
        System.err.println(login);
        return "Username is: "+login.getUsername()+"\n"+
                "Password is: "+login.getPassword();
    }
}
