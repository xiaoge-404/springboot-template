package com.opsbible.app;

import com.opsbible.app.mapper.PersonMapper;
import com.opsbible.app.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppApplicationTests {

	@Autowired
	private PersonMapper personMapper;
	@Test
	void contextLoads() {
		System.out.println("hell test");
		System.out.println(personMapper.select(1));
	}

}
