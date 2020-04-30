package com.opsbible.app.controller;

import com.opsbible.app.common.RestResponse;
import com.opsbible.app.dto.BaseInfo;
import com.opsbible.app.dto.NewEmployee;
import com.opsbible.app.dto.Salary;
import com.opsbible.app.service.EmployeeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "添加一个新员工",notes = "根据参数条件添加员工",httpMethod = "POST")
    @RequestMapping(value = "/employee/add", method = RequestMethod.POST,produces = {"application/json"})
    public RestResponse addEmployee(@RequestBody @ApiParam(name = "员工资料",value = "传入json格式",required = true) NewEmployee newEmployee) throws ParseException {
        return employeeService.addEmployee(newEmployee);
    }

    @ApiOperation(value = "获取员工基本信息",notes = "主要返回员工id和离职日期和在职总收入",httpMethod = "POST")
    @RequestMapping(value = "/employee", method = RequestMethod.POST,produces = {"application/json"})
    public RestResponse showEmployeeInfo(@RequestBody @ApiParam(name = "员工资料",value = "传入json格式",required = true) BaseInfo userInfo) {
        return employeeService.queryEmployeeInfo(userInfo);
    }

    @ApiOperation(value = "删除员工信息",notes = "原本不该删除,但是这里模拟进行删除",httpMethod = "POST")
    @RequestMapping(value = "/employee/delete", method = RequestMethod.POST,produces = {"application/json"})
    public RestResponse deleteEmployeeInfo(@RequestBody @ApiParam(name = "员工资料",value = "传入json格式",required = true) BaseInfo userInfo) {
         return employeeService.deleteEmployeeInfo(userInfo);
    }

    @ApiOperation(value = "修改员工薪资",notes = "修改员工薪资,生效日期",httpMethod = "POST")
    @RequestMapping(value = "/employee/update/salary", method = RequestMethod.POST,produces = {"application/json"})
    public RestResponse modifyEmployeeSalary(@RequestBody @ApiParam(name = "员工薪资",value = "传入json格式",required = true) Salary salary) {
        return employeeService.updateEmployeeSalary(salary);
    }

    @ApiOperation(value = "薪资查询",notes = "根据员工ID查薪资",httpMethod = "GET")
    @RequestMapping(value = "/employee/show/salaries", method = RequestMethod.GET,produces = {"application/json"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "empNo",value = "员工编号",dataType = "Integer")
    })
    public RestResponse showEmployeeSalary(Integer empNo) {
        return employeeService.queryEmployeeSalaries(empNo);
    }

    @ApiOperation(value = "查询员工基本信息",notes = "根据员工ID查信息",httpMethod = "GET")
    @RequestMapping(value = "/employee/show/employeebyempno", method = RequestMethod.GET,produces = {"application/json"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "empNo",value = "员工编号",dataType = "Integer")
    })
    public RestResponse showEmployeeByEmpNo(Integer empNo) {
        return employeeService.queryEmployeeInfoByEmpNo(empNo);
    }

    @ApiOperation(value = "删除员工信息",notes = "根据员工id删除用户信息",httpMethod = "GET")
    @RequestMapping(value = "/employee/delete/employeebyempno", method = RequestMethod.GET,produces = {"application/json"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "empNo",value = "员工编号",dataType = "Integer")
    })
    public RestResponse deleteEmployeeByEmpo(Integer empNo) {
        return employeeService.deleteEmployeeInfoByEmpNo(empNo);
    }

}
