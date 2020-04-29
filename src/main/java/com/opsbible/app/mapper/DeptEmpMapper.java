package com.opsbible.app.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DeptEmpMapper {

    @Select("select dept_name from dept_emp as d left join departments as dt on dt.dept_no=d.dept_no where emp_no = #{empNo}")
    String getDepatmentByEmpNo(Integer empNo);

    @Delete("DELETE FROM dept_emp WHERE emp_no =  #{empNo}")
    int deleteDepartmentByEmpNo(Integer empNo);

}
