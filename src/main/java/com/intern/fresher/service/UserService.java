package com.intern.fresher.service;

import com.intern.fresher.DAL.UserRepository;
import com.intern.fresher.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User addUser(User user)
    {
        userRepository.insertUser(user.getUsername(), user.getFull_name(), user.getAvatar());
        return user;
    }
}
