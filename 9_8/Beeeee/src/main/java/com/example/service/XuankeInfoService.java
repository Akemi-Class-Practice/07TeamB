package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.dao.*;
import com.example.entity.*;
import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Service
public class XuankeInfoService {

    @Resource
    private XuankeInfoDao xuankeInfoDao;

    @Resource
    private YuuzaInfoDao yuuzaInfoDao;
    @Resource
    private ClassInfoDao classInfoDao;


    public List<XuankeInfo> findAll(HttpServletRequest request) {
        Account user = (Account) request.getSession().getAttribute("user");
        if (ObjectUtil.isEmpty(user)) {
            throw new CustomException("-1", "登录已失效，请重新登录");
        }
        List<XuankeInfo> list;
        if (1 == user.getLevel()) {
            // 管理员
            list = xuankeInfoDao.selectAll();
        }  else {
            // 用户
            list = xuankeInfoDao.findByCondition(null, user.getId());
        }
        for (XuankeInfo xuankeInfo : list) {
            

            YuuzaInfo yuuzaInfo = yuuzaInfoDao.selectByPrimaryKey(xuankeInfo.getYuuzaId());
            

            xuankeInfo.setYuuzaName(yuuzaInfo.getName());
        }
        return list;
    }

    public void add(XuankeInfo xuankeInfo) {
        xuankeInfoDao.insertSelective(xuankeInfo);
    }

    public XuankeInfo find(String name, String teacher, Long yuuzaId) {
        return xuankeInfoDao.find(name, teacher, yuuzaId);
    }

    public void delete(Long id) {
        XuankeInfo xuankeInfo = xuankeInfoDao.selectByPrimaryKey(id);
        ClassInfo classInfo = classInfoDao.findByNameAndTeacher(xuankeInfo.getName());
        xuankeInfoDao.deleteByPrimaryKey(id);
        classInfo.setYixuan(classInfo.getYixuan() - 1);
        classInfoDao.updateByPrimaryKeySelective(classInfo);
    }

    public void update(XuankeInfo xuankeInfo) {
        xuankeInfoDao.updateByPrimaryKeySelective(xuankeInfo);
    }
}
