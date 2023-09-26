package com.example.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.entity.Account;
import com.example.service.AdminInfoService;
import com.example.service.YuuzaInfoService;
import com.wf.captcha.utils.CaptchaUtil;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AdminInfoService adminInfoService; 

	@MockBean
	private YuuzaInfoService yuuzaInfoService; 
	
	@Test
    public void testAdminLoginSuccess() throws Exception {
        // 模拟Service方法的行为，根据实际需求进行配置
        when(adminInfoService.login("admin", "2")).thenReturn(new Account()); // 使用实际用户名和密码

        // 模拟请求参数
        String requestBody = "{\"name\":\"admin\",\"password\":\"2\",\"verCode\":\"yourValidCaptcha\",\"level\":1}";

        // 发起POST请求
        mockMvc.perform(post("/login")
                .content(requestBody)
                .contentType("application/json"))
                .andExpect(status().isOk()) // 验证HTTP状态码是否为200，表示请求成功
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0")); // 登录成功
    }

	@Test
	public void testAdminLoginWithValidCaptcha() throws Exception {
		// 准备测试数据
		String name = "admin";
		String password = "2";

		// 创建模拟请求和响应对象
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		// 生成验证码并输出到模拟响应对象
		CaptchaUtil.out(request, response);

		// 获取生成的验证码文本
		String captchaText = (String) request.getSession().getAttribute("captcha");

		// 模拟登录请求，使用正确的验证码
		mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"" + name + "\",\"password\":\"" + password + "\",\"verCode\":\"" + captchaText
						+ "\",\"level\":1}")
				.session(new MockHttpSession())).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0")); // 登录成功
	}

	@Test
	public void testLoginSuccess1() throws Exception {
		// 模拟登录请求
		mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON)
				// .content("{\"name\":\"admin\",\"password\":\"2\",\"verCode\":\"yourVerCode\",\"level\":1}")
				.content("{\"name\":\"admin\",\"password\":\"2\",\"level\":1}").session(new MockHttpSession()))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0")); // 检查返回的JSON中的code字段是否为0，表示成功登录
	}

	@Test
	public void testLoginFailure_verCode() throws Exception {
		// 模拟登录请求，使用错误的验证码
		mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"admin\",\"password\":\"2\",\"verCode\":\"yourVerCode\",\"level\":1}")
				.session(new MockHttpSession())).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value("1001")); // 表示登录失败
	}
	
	// user
	
	@Test
	public void testAdminLoginWithValidCaptcha_User() throws Exception {
		// 准备测试数据
		String name = "2";
		String password = "2";

		// 创建模拟请求和响应对象
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		// 生成验证码并输出到模拟响应对象
		CaptchaUtil.out(request, response);

		// 获取生成的验证码文本
		String captchaText = (String) request.getSession().getAttribute("captcha");

		// 模拟登录请求，使用正确的验证码
		mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"" + name + "\",\"password\":\"" + password + "\",\"verCode\":\"" + captchaText
						+ "\",\"level\":3}")
				.session(new MockHttpSession())).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0")); // 登录成功
	}
	
	@Test
	public void testLoginFailure_verCode_User() throws Exception {
		// 模拟登录请求，使用错误的验证码
		mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"2\",\"password\":\"2\",\"verCode\":\"eee\",\"level\":3}")
				.session(new MockHttpSession())).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value("1001")); // 表示登录失败
	}

}
