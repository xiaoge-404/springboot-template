package com.opsbible.app.service.impl;

import com.opsbible.app.common.RestResponse;
import com.opsbible.app.dto.BaseInfo;
import com.opsbible.app.dto.NewEmployee;
import com.opsbible.app.entity.DeptEmp;
import com.opsbible.app.entity.Titles;
import com.opsbible.app.vo.EmployeeInfo;
import com.opsbible.app.dto.Salary;
import com.opsbible.app.entity.Employees;
import com.opsbible.app.entity.Salaries;
import com.opsbible.app.mapper.DeptEmpMapper;
import com.opsbible.app.mapper.EmployeeMapper;
import com.opsbible.app.mapper.SalaryMapper;
import com.opsbible.app.mapper.TitleMapper;
import com.opsbible.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                .departMent(deptEmpMapper.getDepartmentByEmpNo(employees.getEmpNo()))
                .totalSalaries(totalSalary)
                .build();
        return RestResponse.succuess(employeeInfo);
    }

    @Override
    public RestResponse  deleteEmployeeInfo(BaseInfo userInfo) {

        //如果查询到的userInfo不为null则删除,如果为null就是没有这个用户
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
    public RestResponse  deleteEmployeeInfoByEmpNo(Integer id) {

        //如果查询到的userInfo不为null则删除,如果为null就是没有这个用户
        Employees employees = employeeMapper.selectEmployeeByEmpNo(id);
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
    public  RestResponse updateEmployeeSalary(Salary salary) {
        int  state = salaryMapper.updateSalary(salary);
        if (state == 0) {
            return RestResponse.fail(102,"未查到员工!");
        }
        return RestResponse.succuess();
    }

    @Override
    public RestResponse queryEmployeeSalaries(Integer empNo) {
        List<Salaries> salaries = salaryMapper.selectSalaryByEmpNo(empNo);
        if (salaries == null) {
            return RestResponse.fail(101,"查询salaries数据为空");
        }
        return RestResponse.succuess(salaries);
    }

    @Override
    public RestResponse addEmployee(NewEmployee newEmployee) throws ParseException {

        //添加员工基本信息
        Integer empNo = employeeMapper.getLastEmpNo() + 1;
        Employees employees = Employees.builder()
                .empNo(empNo)
                .birthDate(newEmployee.getBirthDate())
                .firstName(newEmployee.getFirstName())
                .lastName(newEmployee.getLastName())
                .gender(newEmployee.getGender())
                .hireDate(newEmployee.getHireDate())
                .build();
        int state = employeeMapper.addEmployee(employees);
        if (state == 0){
            return RestResponse.fail("用户已经存在!");
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date toDate = new Date(format.parse("9999-01-01").getTime());

        //添加薪资信息
        Salaries salaries = Salaries.builder()
                .empNo(empNo)
                .fromDate(newEmployee.getHireDate())
                .salary(newEmployee.getSalary())
                .toDate(toDate)
                .build();
        state = salaryMapper.addEmployeeSalary(salaries);
        if (state == 0){
            return RestResponse.fail("薪资添加失败!");
        }

        //添加部门信息
        DeptEmp deptEmp = DeptEmp.builder()
                .empNo(empNo)
                .deptNo(newEmployee.getDeptNo())
                .fromDate(newEmployee.getFromDate())
                .toDate(newEmployee.getToDate())
                .build();
        state = deptEmpMapper.addEmployeeDepartment(deptEmp);
        if (state == 0){
            return RestResponse.fail("deptEmp添加失败!");
        }

        //添加职位信息
        Titles titles = Titles.builder()
                .empNo(empNo)
                .title(newEmployee.getTitle())
                .fromDate(newEmployee.getFromDate())
                .toDate(newEmployee.getToDate())
                .build();
        state = titleMapper.addEmployeeTitle(titles);
        if (state == 0){
            return RestResponse.fail("titles添加失败!");
        }
        Employees newEmployees = employeeMapper.selectEmployeeByEmpNo(empNo);
        return RestResponse.succuess(newEmployees);
    }

    @Override
    public RestResponse queryEmployeeInfoByEmpNo(Integer empNo){
        Employees employees = employeeMapper.selectEmployeeByEmpNo(empNo);
        return RestResponse.succuess(employees);
    }
}
