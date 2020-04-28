package com.opsbible.app.mapper;

import com.opsbible.app.dto.BaseInfo;
import com.opsbible.app.entity.Employees;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface EmployeeMapper {

    @Select("SELECT emp_no,birth_date,first_name,last_name,gender,hire_date " +
            "FROM employees " +
            "WHERE first_name=#{firstName} " +
            "AND last_name=#{lastName} " +
            "AND gender=#{gender} " +
            "AND birth_date=#{birthDate} Limit 1")
    Employees selectEmployeeByBaseInfo(BaseInfo userInfo);


    @Select("select status from ping where id=#{id}")
    String ping(Integer id);
}
