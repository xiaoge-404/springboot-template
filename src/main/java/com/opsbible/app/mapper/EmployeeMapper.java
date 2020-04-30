package com.opsbible.app.mapper;

import com.opsbible.app.dto.BaseInfo;
import com.opsbible.app.entity.Employees;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.relational.core.sql.In;


@Mapper
public interface EmployeeMapper {

    @Select("SELECT emp_no,birth_date,first_name,last_name,gender,hire_date " +
            "FROM employees " +
            "WHERE first_name=#{firstName} " +
            "AND last_name=#{lastName} " +
            "AND gender=#{gender} " +
            "AND birth_date=#{birthDate} Limit 1")
    Employees selectEmployeeByBaseInfo(BaseInfo userInfo);

    @Select("SELECT emp_no,birth_date,first_name,last_name,gender,hire_date " +
            "FROM employees " +
            "WHERE emp_no = #{empNo}")
    Employees selectEmployeeByEmpNo(Integer empNo);


    @Delete("DELETE FROM employees WHERE emp_no =  #{empNo}")
    int deleteEmployeeByEmpNo(Integer empNo);

    @Select("select status from ping where id=#{id}")
    String ping(Integer id);

    //获取最后一个员工id
    @Select("select emp_no from employees order by emp_no desc limit 1")
    Integer getLastEmpNo();

    @Insert("INSERT INTO employees(emp_no, birth_date, first_name, last_name, gender, hire_date) " +
            "VALUES( #{empNo},#{birthDate},#{firstName},#{lastName},#{gender},#{hireDate})")
    int addEmployee(Employees employees);
}
