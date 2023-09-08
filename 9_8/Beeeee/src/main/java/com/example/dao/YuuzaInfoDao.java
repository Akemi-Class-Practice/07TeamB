package com.example.dao;

import com.example.entity.YuuzaInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Repository
public interface YuuzaInfoDao extends Mapper<YuuzaInfo> {

    @Select("select * from yuuza_info where name = #{name} and password = #{password}")
    YuuzaInfo findByNameAndPassword(@Param("name") String name, @Param("password") String password);

    @Select("select * from yuuza_info where name = #{name}")
    YuuzaInfo findByName(@Param("name") String name);


}
