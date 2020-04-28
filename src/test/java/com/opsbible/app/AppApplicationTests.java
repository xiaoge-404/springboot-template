package com.opsbible.app;

import com.opsbible.app.dto.BaseInfo;
import com.opsbible.app.dto.EmployeeInfo;
import com.opsbible.app.entity.Employees;
import com.opsbible.app.mapper.EmployeeMapper;
import com.opsbible.app.service.EmployeeService;
import com.opsbible.app.utils.GenderEnum;
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

		BaseInfo baseInfo = BaseInfo.builder()
				.birthDate("1957-05-29")
				.firstName("Mary")
				.lastName("Swift")
				.gender(GenderEnum.MALE.getCode()).build();


		System.out.println(baseInfo.toString());
		Employees e = employeeMapper.selectEmployeeByBaseInfo(baseInfo);
		System.out.println(e.toString());
		String status = employeeMapper.ping(1);
		System.out.println(status);

		EmployeeInfo employeeInfo = employeeService.queryEmployeeInfo(baseInfo);
		System.out.println(employeeInfo.toString());

	}

}
