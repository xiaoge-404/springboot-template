package com.opsbible.app.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TitleMapper {

    @Select("select title from titles where emp_no = #{empNo} order by from_date desc limit 1")
    String getTitleByEmpNo(Integer empNo);

    @Delete("DELETE FROM titles WHERE emp_no =  #{empNo}")
    int deleteTitleByEmpNo(Integer empNo);
}
