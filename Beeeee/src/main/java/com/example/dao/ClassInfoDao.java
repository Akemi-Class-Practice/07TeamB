package com.example.dao;

import com.example.entity.ClassInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Repository
public interface ClassInfoDao extends Mapper<ClassInfo> {


    
    @Select("select * from class_info where name like concat('%', #{search}, '%')")
    List<ClassInfo> findSearch(@Param("search") String search);
    
    @Select("select * from class_info")
    List<ClassInfo> findAll();



//    @Select("select * from class_info where name = #{name} and teacher = #{teacher} limit 1")
//    ClassInfo findByNameAndTeacher(@Param("name") String name);
    @Select("select * from class_info where name = #{name} limit 1")
    ClassInfo findByName(@Param("name") String name);

}
