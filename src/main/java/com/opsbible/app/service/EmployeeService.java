package com.opsbible.app.service;

import com.opsbible.app.common.RestResponse;
import com.opsbible.app.dto.BaseInfo;
import com.opsbible.app.dto.NewEmployee;
import com.opsbible.app.dto.Salary;

import java.text.ParseException;


public interface EmployeeService {

    //通过雇员基本信息获取雇员薪资和状态
    RestResponse queryEmployeeInfo(BaseInfo userInfo);

    //通过雇员id获取雇员薪资和状态
    RestResponse queryEmployeeInfoByEmpNo(Integer empNo);

    //删除雇员信息
    RestResponse deleteEmployeeInfo(BaseInfo userInfo);

    //根据员工id删除
    RestResponse  deleteEmployeeInfoByEmpNo(Integer id);

    //修改员工薪资
    RestResponse updateEmployeeSalary(Salary salary);

    //返回员工薪资详情列表
    RestResponse queryEmployeeSalaries(Integer empNo);

    //添加一个新员工
    RestResponse addEmployee(NewEmployee newEmployee) throws ParseException;

}
