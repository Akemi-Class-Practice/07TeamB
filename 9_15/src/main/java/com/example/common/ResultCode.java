package com.example.common;

public enum ResultCode {
    SUCCESS("0", "成功"),
    ERROR("-1", "システムエラー"),
    PARAM_ERROR("1001", "パラメーターエラー"),
    USER_EXIST_ERROR("2001", "ユーザー名が既に存在します"),
    USER_ACCOUNT_ERROR("2002", "アカウントまたはパスワードが正しくありません"),
    USER_NOT_EXIST_ERROR("2003", "ユーザーが見つかりません"),
    PARAM_LOST_ERROR("2004", "パラメーターが不足しています"),
    PARAM_PASSWORD_ERROR("2005", "元のパスワードが間違っています"),
    USERNAME_NULL("2006", "ユーザー名は空白にできません")
    ;

    public String code;
    public String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
