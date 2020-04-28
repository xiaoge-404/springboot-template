package com.opsbible.app.mapper;

import com.opsbible.app.entity.Salaries;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SalaryMapper {

    @Select("SELECT emp_no,salary,from_date,to_date FROM salaries WHERE emp_no = #{empNo}")
    List<Salaries> selectSalaryByEmpNo(Integer empNo);
}
