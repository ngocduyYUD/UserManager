package com.intern.fresher.service;

import com.intern.fresher.DAL.UserRepository;
import com.intern.fresher.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User addUser(User user)
    {
        //User findUser = userRepository.findById(user.getUser_id());
        //if(findUser == null)
        //{
            //validate name, address, age (1-100)
            userRepository.saveAndFlush(user);
            //userRepository.insertUser(user.getUser_id().toString(), user.getUsername(), user.getFull_name(), user.getAvatar(), user.getAddress());
            return user;
        //}
        //return null;
    }
    public User deleteUserById(UUID id)
    {
        User findUser = userRepository.findById(id);
        if(findUser != null)
        {
            userRepository.deleteById(id);
            return findUser;
        }
        return null;
    }
    public User updateUserRequest(User user)
    {
        User findUser = userRepository.findById(user.getUser_id());
        if(findUser != null)
        {
            userRepository.save(user);
            return user;
        }
        return null;
    }

    public List<User> findUserByName(String name)
    {
        List<User> findUser = userRepository.findByName(name);
        return findUser;
    }

    public List<User> findByAddress(String address)
    {
        List<User> findUser = userRepository.findByAddress(address);
        return findUser;
    }


}
