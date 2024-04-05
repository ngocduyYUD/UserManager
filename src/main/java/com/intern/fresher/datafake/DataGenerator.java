package com.intern.fresher.datafake;

import com.github.javafaker.Faker;
import com.intern.fresher.DAL.UserRepository;
import com.intern.fresher.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataGenerator {
   @Autowired
   UserRepository userRepository;
   public String generateData()
   {
      for (int i = 0; i < 5; i++) {
         Faker faker = new Faker();
         User user = new User();
         user.setUsername(faker.name().username());
         user.setFull_name(faker.name().fullName());
         user.setAvatar(faker.avatar().image());
         user.setAddress(faker.address().fullAddress());
         userRepository.save(user);
      }
      return "Successful";
   }
}
