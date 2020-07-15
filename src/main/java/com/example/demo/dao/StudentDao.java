package com.example.demo.dao;

import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentDao {

    //根据主键id查询
    @Select(" select  id,name from student where id=#{id};")
    public User select(int id);


    //根据主键id查询
    @Select("select  id,name,address from student where id=#{id};")
    public User selectStu(int id);
}
