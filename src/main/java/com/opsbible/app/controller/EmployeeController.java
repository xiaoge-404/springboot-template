package com.opsbible.app.controller;

import com.opsbible.app.dto.BaseInfo;
import com.opsbible.app.dto.EmployeeInfo;
import com.opsbible.app.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@Api(value = "员工信息controller",tags = {"员工信息"})
@RestController
@RequestMapping("/api")
public class EmployeeController {

    /**
     * 用户输入 first_name last_name gender birth_date 返回用户的基本信息
     */
    @Autowired
    EmployeeService employeeService;


    @ApiOperation(value = "获取员工基本信息",notes = "主要返回员工id和离职日期和在职总收入",httpMethod = "POST")
    @RequestMapping(value = "/employee", method = RequestMethod.POST,produces = {"application/json"})
    public EmployeeInfo showEmployeeInfo(@RequestBody @ApiParam(name = "员工资料",value = "传入json格式",required = true) BaseInfo userInfo) {
        return employeeService.queryEmployeeInfo(userInfo);
    }
}
