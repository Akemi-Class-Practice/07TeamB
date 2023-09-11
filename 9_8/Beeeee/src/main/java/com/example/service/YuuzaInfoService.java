package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.ResultCode;
import com.example.dao.YuuzaInfoDao;

import com.example.entity.Account;
import com.example.entity.YuuzaInfo;

import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class YuuzaInfoService {

    @Resource
    private YuuzaInfoDao yuuzaInfoDao;



    public Account login(String name, String password) {

        // 去数据库里根据ユーザー名和密码查询ユーザー情報
        YuuzaInfo yuuzaInfo = yuuzaInfoDao.findByNameAndPassword(name, password);
        if (ObjectUtil.isEmpty(yuuzaInfo)) {
            throw new CustomException("-1", "ユーザー名、密码或者角色选择错误");
        }

        return yuuzaInfo;
    }

    public YuuzaInfo findById(Long id) {
        return yuuzaInfoDao.selectByPrimaryKey(id);
    }

    public void update(YuuzaInfo yuuzaInfo) {
        yuuzaInfoDao.updateByPrimaryKeySelective(yuuzaInfo);
    }

    public List<YuuzaInfo> finAll() {
        // 处理一下这个list，把里面每一个ユーザー情報对应的学院名称搞进去
        // 方式一：使用Java代码逻辑来实现关联查询
        List<YuuzaInfo> list = yuuzaInfoDao.selectAll();
        for (YuuzaInfo yuuzaInfo : list) {
        }
        return list;

//        // 方式二：使用sql关联查询语句直接查
//        return yuuzaInfoDao.findAllJoinXueyuan();
//
    }

    public void add(YuuzaInfo yuuzaInfo) {
        // 1. 从数据库中根据ユーザー名查询查一条信息，如果有说明ユーザー名重复，提示重新输入
        YuuzaInfo info = yuuzaInfoDao.findByName(yuuzaInfo.getName());
        if (ObjectUtil.isNotEmpty(info)) {
            throw new CustomException(ResultCode.USER_EXIST_ERROR);
        }
        // 2. 如果没有填密码，初始化一个默认密码
        if (ObjectUtil.isEmpty(yuuzaInfo.getPassword())) {
            yuuzaInfo.setPassword("123456");
        }
        
     // 设置默认的 level 为 3
        yuuzaInfo.setLevel(3);
        
        yuuzaInfoDao.insertSelective(yuuzaInfo);
    }

    public void deleteById(Long id) {
        yuuzaInfoDao.deleteByPrimaryKey(id);
    }
}
