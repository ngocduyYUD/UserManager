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
      CreateDataThread thread4 = new CreateDataThread("Thread4", userRepository);
      thread4.start();
//      Random r = new Random();
//      for (int i = 0; i < 1000; i++) {
//         Faker faker = new Faker();
//         User user = new User();
//         user.setUsername(faker.name().username());
//         user.setFullname(faker.name().fullName());
//         user.setAvatar(faker.avatar().image());
//         user.setAddress(faker.address().fullAddress());
//         user.setAge(r.nextInt(100-1)+1);
//         userRepository.save(user);
//      }
      return "Successful";
   }
}
