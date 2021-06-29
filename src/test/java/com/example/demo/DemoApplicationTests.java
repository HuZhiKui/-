package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
	private UserRepository repository;
	@Test
	void contextLoads() {
	}
	@Test
	void  save(){
		User user = new User();
		user.setName("小明");
		user.setCheckpass("123");
		user.setPassword("123");
		user.setEmail("11-11");
		user.setPhonenum(11000000);
		User use = repository.save(user);
		System.out.println(use);
	}

}
