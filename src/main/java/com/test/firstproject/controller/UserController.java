package com.test.firstproject.controller;

import com.test.firstproject.entity.User;
import com.test.firstproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("http://localhost:4200")
@RequestMapping("/sms/api/v1/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.saveUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> checkValidUser(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.checkValidUser(user));
    }
}
