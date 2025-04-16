package com.saurabh.FirstJobApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstJobAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstJobAppApplication.class, args);
	}

}


//JPA java persistence API
// DataBase
// Allows object(Job) to convert to relational DB.
//ADV
//1. Easy and Simple
//2. Makes Query Easy
//3. Allows to save and update objects
//4. Easy Integration with Spring Boot.

//🧠 What is “Loosely Coupled”?
//Loose coupling means:
//Your classes don’t depend on each other too tightly
//They depend on interfaces or abstractions instead of specific implementations
//This makes your code more flexible, testable, and maintainable


// Ping is to check if one container is able to communicate with the other container which are on the same network
