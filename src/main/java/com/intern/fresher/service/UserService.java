package com.intern.fresher.service;

import com.intern.fresher.DAL.UserRepository;
import com.intern.fresher.entity.User;
import com.intern.fresher.response.UserResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public UserResponseMessage addUser(User user)
    {
        UserResponseMessage userResponseMessage = new UserResponseMessage();
        if(validateUser(user))
        {
            userResponseMessage.setMessage("wrong type data");
            userResponseMessage.setStatus(0);
            userResponseMessage.setCode(900);
            userResponseMessage.setData(null);
            return userResponseMessage;
        }
        if(!userRepository.existsById(user.getUserid()))
        {
            userRepository.save(user);
            List<User> users = new ArrayList<>();
            users.add(userRepository.findLastRecord());
            userResponseMessage.setMessage("add user information");
            userResponseMessage.setStatus(1);
            userResponseMessage.setCode(HttpStatus.OK.value());
            userResponseMessage.setData(users);
            return userResponseMessage;
        }
        userResponseMessage.setMessage("User already exist");
        userResponseMessage.setStatus(0);
        userResponseMessage.setCode(902);
        userResponseMessage.setData(null);
        return userResponseMessage;
    }
    public UserResponseMessage deleteUserById(UUID id)
    {
        UserResponseMessage userResponseMessage = new UserResponseMessage();
        if(userRepository.existsById(id))
        {
            User returnUser = userRepository.findByUserid(id);
            userRepository.delete(returnUser);
            List<User> users = new ArrayList<>();
            users.add(returnUser);
            userResponseMessage.setMessage("delete user information");
            userResponseMessage.setStatus(1);
            userResponseMessage.setCode(HttpStatus.OK.value());
            userResponseMessage.setData(users);
            return userResponseMessage;
        }
        userResponseMessage.setMessage("User not found");
        userResponseMessage.setStatus(0);
        userResponseMessage.setCode(HttpStatus.NOT_FOUND.value());
        userResponseMessage.setData(null);
        return userResponseMessage;
    }
    public UserResponseMessage updateUserRequest(User user)
    {
        UserResponseMessage userResponseMessage = new UserResponseMessage();
        if(validateUser(user))
        {
            userResponseMessage.setMessage("wrong type data");
            userResponseMessage.setStatus(0);
            userResponseMessage.setCode(900);
            userResponseMessage.setData(null);
            return userResponseMessage;
        }
        if(userRepository.existsById(user.getUserid()))
        {
            userRepository.save(user);
            List<User> users = new ArrayList<>();
            users.add(user);
            userResponseMessage.setMessage("update user information");
            userResponseMessage.setStatus(1);
            userResponseMessage.setCode(HttpStatus.OK.value());
            userResponseMessage.setData(users);
            return userResponseMessage;
        }
        userResponseMessage.setMessage("User not found");
        userResponseMessage.setStatus(0);
        userResponseMessage.setCode(HttpStatus.NOT_FOUND.value());
        userResponseMessage.setData(null);
        return userResponseMessage;
    }

    public UserResponseMessage findUserByName(String name)
    {
        UserResponseMessage userResponseMessage = new UserResponseMessage();
        List<User> findUser = userRepository.findByUsernameContaining(name);
        userResponseMessage.setMessage("user information");
        userResponseMessage.setStatus(1);
        userResponseMessage.setCode(HttpStatus.OK.value());
        userResponseMessage.setData(findUser);
        return userResponseMessage;
    }

    public UserResponseMessage findUserUsingId(UUID id)
    {
        UserResponseMessage userResponseMessage = new UserResponseMessage();
        User user = userRepository.findByUserid(id);
        if(user != null)
        {
            List<User> users = new ArrayList<>();
            users.add(user);
            userResponseMessage.setMessage("user information");
            userResponseMessage.setStatus(1);
            userResponseMessage.setCode(HttpStatus.OK.value());
            userResponseMessage.setData(users);
            return userResponseMessage;
        }
        userResponseMessage.setMessage("user not found");
        userResponseMessage.setStatus(0);
        userResponseMessage.setCode(HttpStatus.NOT_FOUND.value());
        userResponseMessage.setData(null);
        return userResponseMessage;
    }

    public UserResponseMessage findUserByAddress(String address)
    {
        UserResponseMessage userResponseMessage = new UserResponseMessage();
        List<User> findUser = userRepository.findByAddressContaining(address);
        userResponseMessage.setMessage("user information");
        userResponseMessage.setStatus(1);
        userResponseMessage.setCode(HttpStatus.OK.value());
        userResponseMessage.setData(findUser);
        return userResponseMessage;
    }

    public UserResponseMessage sortUserByName()
    {
        List<User> users = userRepository.findAll();
        UserResponseMessage userResponseMessage = new UserResponseMessage();
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User s1, User s2) {
                String[] name1 = s1.getUsername().split("/.");
                String[] name2 = s2.getUsername().split("/.");
                return name1[name1.length - 1].compareTo(name2[name2.length - 1]);
            }
        });
        userResponseMessage.setMessage("sort users");
        userResponseMessage.setStatus(1);
        userResponseMessage.setCode(HttpStatus.OK.value());
        userResponseMessage.setData(users);
        return userResponseMessage;
    }

    public boolean validateUser(User user)
    {
        if(user.getUsername().isEmpty())
        {
            return true;
        }
        if(user.getAddress().isEmpty())
        {
            return true;
        }
        if(user.getAge() < 1 || user.getAge() > 100)
        {
            return true;
        }
        return false;
    }
}
