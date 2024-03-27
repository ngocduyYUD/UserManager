package com.intern.fresher.controller;

import com.intern.fresher.datafake.DataGenerator;
import com.intern.fresher.entity.User;
import com.intern.fresher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/UserController")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    DataGenerator dataGenerator;
    @GetMapping("/dataGenerator")
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
    public ResponseEntity<User> addNewUser(@RequestBody User user)
    {
        try{
            User result = userService.addUser(user);
            if(result == null)
            {
                return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
