package com.example.common;

import java.util.regex.Pattern;

public class PasswordComplex {
	// 验证密码复杂性的方法
	public static boolean isPasswordComplex(String password) {
	    // 密码包含至少一个大写字母、一个小写字母、一个数字和一个特殊字符
	    return Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).+$").matcher(password).matches();
	}

}
