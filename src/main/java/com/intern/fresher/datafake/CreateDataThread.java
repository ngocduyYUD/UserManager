package com.intern.fresher.datafake;

import com.github.javafaker.Faker;
import com.intern.fresher.DAL.UserRepository;
import com.intern.fresher.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

public class CreateDataThread implements Runnable{
    private Thread t;
    private String threadName;
    private UserRepository userRepository;
    CreateDataThread(String name, UserRepository userRepository) {
        threadName = name;
        this.userRepository = userRepository;
        System.out.println("Creating " + threadName);
    }
    @Override
    public void run() {
        System.out.println("Running " + threadName);
        Random r = new Random();
        for (int i = 0; i < 250; i++) {
            Faker faker = new Faker();
            User user = new User();
            user.setUsername(faker.name().username());
            user.setFullname(faker.name().fullName());
            user.setAvatar(faker.avatar().image());
            user.setAddress(faker.address().fullAddress());
            user.setAge(r.nextInt(100-1)+1);
            userRepository.save(user);
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
