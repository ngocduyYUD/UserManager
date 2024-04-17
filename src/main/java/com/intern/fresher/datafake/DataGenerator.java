package com.intern.fresher.datafake;

import com.github.javafaker.Faker;
import com.intern.fresher.DAL.UserRepository;
import com.intern.fresher.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DataGenerator {
   @Autowired
   UserRepository userRepository;
   public String generateData(){
      CreateDataThread thread1 = new CreateDataThread("Thread1", userRepository);
      thread1.start();
      CreateDataThread thread2 = new CreateDataThread("Thread2", userRepository);
      thread2.start();
      CreateDataThread thread3 = new CreateDataThread("Thread3", userRepository);
      thread3.start();
      return "Successful";
   }
}
