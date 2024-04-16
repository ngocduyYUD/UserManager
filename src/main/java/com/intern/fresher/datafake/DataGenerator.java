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
   public String generateData()
   {
      Random r = new Random();
      for (int i = 0; i < 100; i++) {
         Faker faker = new Faker();
         User user = new User();
         user.setUsername(faker.name().username());
         user.setFullname(faker.name().fullName());
         user.setAvatar(faker.avatar().image());
         user.setAddress(faker.address().fullAddress());
         user.setAge(r.nextInt(100-1)+1);
         userRepository.save(user);
      }
      return "Successful";
   }
}
