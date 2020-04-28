package com.opsbible.app.mapper;

import com.opsbible.app.entity.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface PersonMapper  {
    @Insert("insert into person(id,name,age) values(#{id},#{name},#{age})")
    int insert(Person person);

    @Select("select name from person where id=#{id}")
    String select(Integer id);
}
