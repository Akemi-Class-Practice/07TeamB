package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.entity.ClassInfo;
import com.example.entity.InquiryInfo;
import com.example.entity.YuuzaInfo;

import tk.mybatis.mapper.common.Mapper;

public interface InquiryInfoDao extends Mapper<InquiryInfo> {

	@Select("select * from inquiry_info where name like concat('%', #{search}, '%')")
	List<InquiryInfo> findSearch(@Param("search") String search);

	@Select("select * from inquiry_info")
	List<InquiryInfo> findAll();

}
