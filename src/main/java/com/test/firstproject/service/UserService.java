package com.test.firstproject.service;

import com.test.firstproject.entity.User;
import com.test.firstproject.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String saveUser(User user) {
        User savedUser = this.userRepository.save(user);
        if(savedUser != null) {
            return "success";
        } else {
            return "failed";
        }
    }

    public User checkValidUser(User user) {
        return this.userRepository.findUserByUserNameAndPassword(user.getUserName(), user.getPassword()).get(0);
    }
}
