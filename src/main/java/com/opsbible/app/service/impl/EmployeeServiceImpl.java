package com.opsbible.app.service.impl;

import com.opsbible.app.common.RestResponse;
import com.opsbible.app.dto.BaseInfo;
import com.opsbible.app.dto.EmployeeInfo;
import com.opsbible.app.dto.Salary;
import com.opsbible.app.dto.UpdateSalary;
import com.opsbible.app.entity.Employees;
import com.opsbible.app.entity.Salaries;
import com.opsbible.app.mapper.DeptEmpMapper;
import com.opsbible.app.mapper.EmployeeMapper;
import com.opsbible.app.mapper.SalaryMapper;
import com.opsbible.app.mapper.TitleMapper;
import com.opsbible.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private SalaryMapper salaryMapper;

    @Autowired
    private DeptEmpMapper deptEmpMapper;

    @Autowired
    private TitleMapper titleMapper;



    @Override
    public RestResponse queryEmployeeInfo(BaseInfo userInfo) {

        Employees employees = employeeMapper.selectEmployeeByBaseInfo(userInfo);
        if (employees == null) {
            return RestResponse.fail(101,"查询employees数据为空");
        }
        List<Salaries> salaries = salaryMapper.selectSalaryByEmpNo(employees.getEmpNo());
        if (salaries == null) {
            return RestResponse.fail(102,"查询salaries数据为空");
        }
        Integer totalSalary = 0;
        for (int i = 0; i < salaries.size(); i++) {
            totalSalary += salaries.get(i).getSalary();
        }
        EmployeeInfo employeeInfo = EmployeeInfo.builder()
                .empNo(employees.getEmpNo())
                .userInfo(userInfo)
                .departureDate(salaries.get(salaries.size()-1).getToDate())
                .hireDate(employees.getHireDate())
                .title(titleMapper.getTitleByEmpNo(employees.getEmpNo()))
                .departMent(deptEmpMapper.getDepatmentByEmpNo(employees.getEmpNo()))
                .totalSalaries(totalSalary)
                .build();
        return RestResponse.succuess(employeeInfo);
    }

    @Override
    public RestResponse  deleteEmployeeInfo(BaseInfo userInfo) {

        Employees employees = employeeMapper.selectEmployeeByBaseInfo(userInfo);
        if (employees == null) {
            return RestResponse.fail(101,"查询employees数据为空");
        }

        Integer empNo = employees.getEmpNo();
        employeeMapper.deleteEmployeeByEmpNo(empNo);
        deptEmpMapper.deleteDepartmentByEmpNo(empNo);
        salaryMapper.deleteSalaryByEmpNo(empNo);
        titleMapper.deleteTitleByEmpNo(empNo);
        return RestResponse.succuess();
    }
    @Override
    public  RestResponse updateEmployeeSalary(UpdateSalary updateSalary) {
        Employees employees = employeeMapper.selectEmployeeByBaseInfo(updateSalary.getBaseInfo());
        if (employees == null) {
            return RestResponse.fail(101,"查询employees数据为空");
        }
        Salary salary = Salary.builder()
                .salary(updateSalary.getSalary())
                .empNo(employees.getEmpNo())
                .fromDate(updateSalary.getFromDate())
                .build();
        salaryMapper.updataSalary(salary);
        return RestResponse.succuess();
    }
}
