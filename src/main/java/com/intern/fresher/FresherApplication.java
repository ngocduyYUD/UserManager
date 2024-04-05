package com.intern.fresher;

import com.github.javafaker.Faker;
import com.intern.fresher.DAL.UserRepository;
import com.intern.fresher.datafake.DataGenerator;
import com.intern.fresher.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FresherApplication {
	public static void main(String[] args) {
		SpringApplication.run(FresherApplication.class, args);
	}
}
