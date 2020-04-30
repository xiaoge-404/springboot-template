package com.opsbible.app;

import com.opsbible.app.mapper.EmployeeMapper;
import com.opsbible.app.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootTest
class AppApplicationTests {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private EmployeeService employeeService;

	@Test
	void contextLoads() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = format.parse("9999-01-01");


	}

}
