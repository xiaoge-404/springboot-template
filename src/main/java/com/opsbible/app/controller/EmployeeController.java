package com.opsbible.app.controller;

import com.opsbible.app.common.RestResponse;
import com.opsbible.app.dto.BaseInfo;
import com.opsbible.app.dto.UpdateSalary;
import com.opsbible.app.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


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
    public RestResponse modifyEmployeeSalary(@RequestBody @ApiParam(name = "员工薪资",value = "传入json格式",required = true) UpdateSalary updateSalary) {
        return employeeService.updateEmployeeSalary(updateSalary);
    }
}
