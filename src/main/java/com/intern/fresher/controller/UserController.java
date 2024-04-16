package com.intern.fresher.controller;

import com.intern.fresher.datafake.DataGenerator;
import com.intern.fresher.entity.User;
import com.intern.fresher.response.UserResponseMessage;
import com.intern.fresher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/UserController")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    DataGenerator dataGenerator;
    @PostMapping("/dataGenerator")
    public ResponseEntity<String> generatorData()
    {
        try{
            String result = dataGenerator.generateData();
            if(!result.equals("Successful"))
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/addUser")
    public ResponseEntity<UserResponseMessage> addNewUser(@RequestBody User user)
    {
        try{
            UserResponseMessage result = userService.addUser(user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping ("/deleteUser/{id}")
    public ResponseEntity<UserResponseMessage> deleteUser(@PathVariable UUID id)
    {
        try{
            UserResponseMessage result = userService.deleteUserById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/updateUser")
    public ResponseEntity<UserResponseMessage> updateUser(@RequestBody User user)
    {
        try{
            UserResponseMessage result = userService.updateUserRequest(user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/findByName/{name}")
    public ResponseEntity<UserResponseMessage> findByName(@PathVariable String name)
    {
        try{
            UserResponseMessage result = userService.findUserByName(name);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<UserResponseMessage> findById(@PathVariable UUID id)
    {
        try{
            UserResponseMessage result = userService.findUserUsingId(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/findByAddress/{address}")
    public ResponseEntity<UserResponseMessage> findByAddress(@PathVariable String address)
    {
        try{
            UserResponseMessage result = userService.findUserByAddress(address);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/sortUserByName")
    public ResponseEntity<UserResponseMessage> sortUserName()
    {
        try{
            UserResponseMessage result = userService.sortUserByName();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
