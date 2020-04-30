package com.opsbible.app.mapper;

import com.opsbible.app.dto.Salary;
import com.opsbible.app.entity.Salaries;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SalaryMapper {

    @Select("SELECT emp_no,salary,from_date,to_date FROM salaries WHERE emp_no = #{empNo}")
    List<Salaries> selectSalaryByEmpNo(Integer empNo);

    @Delete("DELETE FROM salaries WHERE emp_no =  #{empNo}")
    int deleteSalaryByEmpNo(Integer empNo);

    @Update("UPDATE salaries SET salary = #{salary}, from_date = #{fromDate} WHERE emp_no =  #{empNo}")
    int updateSalary(Salary salary);

    @Insert("INSERT INTO salaries " +
            "(emp_no, salary, from_date, to_date) " +
            "VALUES (#{empNo}, #{salary}, #{fromDate}, #{toDate})")
    int addEmployeeSalary(Salaries Salaries);
}
