package com.project;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


import com.project.dao.UserDao;
import com.project.entities.User;

@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class SpServerApplicationDemo implements CommandLineRunner {

	
	
	public static void main(String[] args) {
		SpringApplication.run(SpServerApplicationDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			
		
	}


}
