package com.opsbible.app.mapper;

import com.opsbible.app.entity.DeptEmp;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DeptEmpMapper {

    @Select("select dept_name from dept_emp as d left join departments as dt on dt.dept_no=d.dept_no where emp_no = #{empNo}")
    String getDepartmentByEmpNo(Integer empNo);

    @Delete("DELETE FROM dept_emp WHERE emp_no =  #{empNo}")
    int deleteDepartmentByEmpNo(Integer empNo);

    @Insert("INSERT INTO dept_emp (emp_no, dept_no, from_date, to_date) " +
            "VALUES (#{empNo}, #{deptNo}, #{fromDate}, #{toDate})")
    int addEmployeeDepartment(DeptEmp deptEmp);
}
