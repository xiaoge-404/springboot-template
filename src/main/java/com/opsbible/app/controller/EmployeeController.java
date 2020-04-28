package com.opsbible.app.controller;

import com.opsbible.app.dto.BaseInfo;
import com.opsbible.app.dto.EmployeeInfo;
import com.opsbible.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    /**
     * 用户输入 first_name last_name gender birth_date 返回用户的基本信息
     */
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
    public EmployeeInfo showEmployeeInfo(@RequestBody BaseInfo userInfo) {
        return employeeService.queryEmployeeInfo(userInfo);
    }
}
