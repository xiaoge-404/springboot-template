package com.opsbible.app.service;

import com.opsbible.app.common.RestResponse;
import com.opsbible.app.dto.BaseInfo;
import com.opsbible.app.dto.EmployeeInfo;
import com.opsbible.app.dto.Salary;
import com.opsbible.app.dto.UpdateSalary;


public interface EmployeeService {

    //通过雇员基本信息获取雇员薪资和状态
    RestResponse queryEmployeeInfo(BaseInfo userInfo);

    //删除雇员信息
    RestResponse deleteEmployeeInfo(BaseInfo userInfo);

    //修改员工薪资
    RestResponse updateEmployeeSalary(UpdateSalary updateSalary);

}
