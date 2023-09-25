package com.example.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.common.ResultCode;
import com.example.dao.ClassInfoDao;
import com.example.dao.InquiryInfoDao;
import com.example.entity.ClassInfo;
import com.example.entity.InquiryInfo;
import com.example.entity.YuuzaInfo;
import com.example.exception.CustomException;

import cn.hutool.core.util.ObjectUtil;
import tk.mybatis.mapper.common.base.insert.InsertSelectiveMapper;

@Service
public class InquiryInfoService {
	
	@Resource
    private InquiryInfoDao inquiryInfoDao;

	public void add(InquiryInfo inquiryInfo) {
		inquiryInfoDao.insertSelective(inquiryInfo);
	}

	public List<InquiryInfo> findAll() {
		return inquiryInfoDao.findAll();
	}

}
