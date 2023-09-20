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
 * 説明：アカウント関連のAPI
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
        // PNG形式
        SpecCaptcha captcha = new SpecCaptcha(135, 33, 1); // キャプチャの桁数
        captcha.setCharType(Captcha.TYPE_NUM_AND_UPPER);
        CaptchaUtil.out(captcha, request, response);
        

    }

    /**
     * 説明：ログイン機能
     * @param user ログインユーザー情報
     * @param request リクエスト
     * @return Result
     */
    @PostMapping("/login")
    public Result login(@RequestBody Account user, HttpServletRequest request) {

        // データが入力されているかどうかを確認
        if (ObjectUtil.isEmpty(user.getName()) || ObjectUtil.isEmpty(user.getPassword()) || ObjectUtil.isEmpty(user.getLevel())) {
            return Result.error("-1", "入力情報を完了してください");
        }

        if (!CaptchaUtil.ver(user.getVerCode(), request)) {
            // セッションの中のキャプチャをクリア
            CaptchaUtil.clear(request);
            return Result.error("1001", "キャプチャが正しくありません");
        }

        Integer level = user.getLevel();
        Account loginUser = new Account();
        if (1 == level) {
            // 管理者ログイン
            loginUser = adminInfoService.login(user.getName(), user.getPassword());
        }
        if (3 == level) {
            // ユーザーログイン
            loginUser = yuuzaInfoService.login(user.getName(), user.getPassword());
        }

        // セッションにユーザー情報を保存
        request.getSession().setAttribute("user", loginUser);

        return Result.success(loginUser);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Account user, HttpServletRequest request) {
        // データが入力されているかどうかを確認
        if (ObjectUtil.isEmpty(user.getName()) || ObjectUtil.isEmpty(user.getPassword()) || ObjectUtil.isEmpty(user.getLevel())) {
            return Result.error("-1", "入力情報を完了してください");
        }

        Integer level = user.getLevel();
        if (3 == level) {
            // ユーザー登録
            YuuzaInfo yuuzaInfo = new YuuzaInfo();
            BeanUtils.copyProperties(user, yuuzaInfo);
            yuuzaInfoService.add(yuuzaInfo);
        }

        return Result.success();
    }

    /**
     * 現在のログインユーザーを取得
     * @param request
     * @return
     */
    @GetMapping("/getUser")
    public Result getUser(HttpServletRequest request) {
        // セッションから現在のログインユーザー情報を取得
        Account user = (Account) request.getSession().getAttribute("user");
        // 現在のログインユーザーの役割を判断
        Integer level = user.getLevel();
        if (1 == level) {
            // 管理者を取得
            AdminInfo adminInfo = adminInfoService.findById(user.getId());
            return Result.success(adminInfo);
        }
        if (3 == level) {
            // ユーザーテーブルからユーザー情報を取得
            YuuzaInfo yuuzaInfo = yuuzaInfoService.findById(user.getId());
            return Result.success(yuuzaInfo);
        }
        return Result.success(new Account());
    }

    @PostMapping("/updatePassword")
    public Result updatePassword(@RequestBody Account account, HttpServletRequest request) {
        // 1. 現在のログインユーザーがどの役割かを知る
        Account user = (Account) request.getSession().getAttribute("user");
        // 2. 元のパスワードが正しいかどうかを確認
        String oldPassword = account.getPassword();
        if (!user.getPassword().equals(oldPassword)) {
            return Result.error("-1", "元のパスワードが間違っています");
        }
        String newPassword = account.getNewPassword();
        // 現在のログインユーザーの役割に応じて、対応するデータベーステーブルでパスワードを更新
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
        // 3. セッション中のログインユーザー情報をクリア
        request.getSession().setAttribute("user", null);
        return Result.success();
    }

    @GetMapping("/logout")
    public Result logout(HttpServletRequest request) {
        request.getSession().setAttribute("user", null);
        return Result.success();
    }
}
