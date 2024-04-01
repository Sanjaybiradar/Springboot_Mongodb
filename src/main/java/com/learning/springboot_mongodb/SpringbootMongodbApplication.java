package com.learning.springboot_mongodb;

import com.learning.springboot_mongodb.entity.User;
import com.learning.springboot_mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class SpringbootMongodbApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("21","Sanjay","sanjay@tcs.com","abc@321");
		userRepository.save(user);
	}
}
