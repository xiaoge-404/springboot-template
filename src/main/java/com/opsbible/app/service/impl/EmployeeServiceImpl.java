package com.opsbible.app.service.impl;

import com.opsbible.app.dto.BaseInfo;
import com.opsbible.app.dto.EmployeeInfo;
import com.opsbible.app.entity.Employees;
import com.opsbible.app.entity.Salaries;
import com.opsbible.app.mapper.EmployeeMapper;
import com.opsbible.app.mapper.SalaryMapper;
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

    @Override
    public EmployeeInfo queryEmployeeInfo(BaseInfo userInfo) {

        Employees employees = employeeMapper.selectEmployeeByBaseInfo(userInfo);

        List<Salaries> salaries = salaryMapper.selectSalaryByEmpNo(employees.getEmpNo());
        Integer totalSalary = 0;
        for (int i = 0; i < salaries.size(); i++) {
            totalSalary += salaries.get(i).getSalary();
        }

        EmployeeInfo employeeInfo = EmployeeInfo.builder()
                .empNo(employees.getEmpNo())
                .userInfo(userInfo)
                .departureDate(salaries.get(salaries.size()-1).getToDate())
                .hireDate(employees.getHireDate())
                .totalSalaries(totalSalary)
                .build();

        return employeeInfo;
    }
}
