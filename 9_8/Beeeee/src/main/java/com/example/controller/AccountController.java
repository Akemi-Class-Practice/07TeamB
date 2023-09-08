package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.entity.Account;
import com.example.entity.AdminInfo;
import com.example.entity.YuuzaInfo;

import com.example.service.AdminInfoService;
import com.example.service.YuuzaInfoService;

import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 描述：跟账号相关的接口
 */
@RestController
@RequestMapping
public class AccountController {

    @Resource
    private AdminInfoService adminInfoService;

    @Resource
    private YuuzaInfoService yuuzaInfoService;


    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // png类型
        SpecCaptcha captcha = new SpecCaptcha(135, 33, 1); // 验证码的位数
        captcha.setCharType(Captcha.TYPE_NUM_AND_UPPER);
        CaptchaUtil.out(captcha, request, response);

    }

    /**
     * 描述：登录功能
     * @param user 登录ユーザー情報
     * @param request request请求
     * @return Result
     */
    @PostMapping("/login")
    public Result login(@RequestBody Account user, HttpServletRequest request) {

        // 校验数据有没有填
        if (ObjectUtil.isEmpty(user.getName()) || ObjectUtil.isEmpty(user.getPassword()) || ObjectUtil.isEmpty(user.getLevel())) {
            return Result.error("-1", "请完善输入信息");
        }

//        if (!CaptchaUtil.ver(user.getVerCode(), request)) {
//            // 清除session中的验证码
//            CaptchaUtil.clear(request);
//            return Result.error("1001", "验证码不正确");
//        }

        Integer level = user.getLevel();
        Account loginUser = new Account();
        if (1 == level) {
            // 管理员登录
            loginUser = adminInfoService.login(user.getName(), user.getPassword());
        }
        if (3 == level) {
            // 用户登录
            loginUser = yuuzaInfoService.login(user.getName(), user.getPassword());
        }

        // 在session里面把ユーザー情報存一份
        request.getSession().setAttribute("user", loginUser);

        return Result.success(loginUser);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Account user, HttpServletRequest request) {
        // 校验数据有没有填
        if (ObjectUtil.isEmpty(user.getName()) || ObjectUtil.isEmpty(user.getPassword()) || ObjectUtil.isEmpty(user.getLevel())) {
            return Result.error("-1", "请完善输入信息");
        }

        Integer level = user.getLevel();
        if (3 == level) {
            // 用户注册
            YuuzaInfo yuuzaInfo = new YuuzaInfo();
            BeanUtils.copyProperties(user, yuuzaInfo);
            yuuzaInfoService.add(yuuzaInfo);
        }

        return Result.success();
    }

    /**
     * 获取当前登录的用户
     * @param request
     * @return
     */
    @GetMapping("/getUser")
    public Result getUser(HttpServletRequest request) {
        // 先从session里面获取当前存的登录ユーザー情報
        Account user = (Account) request.getSession().getAttribute("user");
        // 判断当前登录的用户是什么角色
        Integer level = user.getLevel();
        if (1 == level) {
            // 获取管理员
            AdminInfo adminInfo = adminInfoService.findById(user.getId());
            return Result.success(adminInfo);
        }
        if (3 == level) {
            // 从用户表里面获取ユーザー情報
            YuuzaInfo yuuzaInfo = yuuzaInfoService.findById(user.getId());
            return Result.success(yuuzaInfo);
        }
        return Result.success(new Account());
    }

    @PostMapping("/updatePassword")
    public Result updatePassword(@RequestBody Account account, HttpServletRequest request) {
        // 1. 知道当前登录用户是哪个角色
        Account user = (Account) request.getSession().getAttribute("user");
        // 2. 判断原密码对不对
        String oldPassword = account.getPassword();
        if (!user.getPassword().equals(oldPassword)) {
            return Result.error("-1", "原密码输入错误");
        }
        String newPassword = account.getNewPassword();
        // 判断当前登录的用户是什么角色，根据角色，去对应的数据库表里更新密码
        Integer level = user.getLevel();
        if (1 == level) {
            AdminInfo adminInfo = new AdminInfo();
            BeanUtils.copyProperties(user, adminInfo);
            adminInfo.setPassword(newPassword);
            adminInfoService.update(adminInfo);
        }

        if (3 == level) {
            YuuzaInfo yuuzaInfo = new YuuzaInfo();
            BeanUtils.copyProperties(user, yuuzaInfo);
            yuuzaInfo.setPassword(newPassword);
            yuuzaInfoService.update(yuuzaInfo);
        }
        // 3. 把session中的登录ユーザー情報给清掉
        request.getSession().setAttribute("user", null);
        return Result.success();
    }

    @GetMapping("/logout")
    public Result logout(HttpServletRequest request) {
        request.getSession().setAttribute("user", null);
        return Result.success();
    }
}
