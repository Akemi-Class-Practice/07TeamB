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
		// 管理者ユーザー名とパスワードログイン
        when(adminInfoService.login("admin", "2")).thenReturn(new Account()); 

        // 
        String requestBody = "{\"name\":\"admin\",\"password\":\"2\",\"verCode\":\"yourValidCaptcha\",\"level\":1}";

        //POSTリクエストを送信する
        mockMvc.perform(post("/login")
                .content(requestBody)
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0")); // ログイン成功
    }

	@Test
	public void testAdminLoginWithValidCaptcha() throws Exception {
		// adminテストデータ
		String name = "admin";
		String password = "2";

		// リクエストとレスポンスオブジェクトを作成
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		// キャプチャコードを生成し、レスポンスオブジェクトに出力
		CaptchaUtil.out(request, response);

		// 生成されたキャプチャコードのテキストを取得する
		String captchaText = (String) request.getSession().getAttribute("captcha");

		// 正しいキャプチャコードを使用してログインリクエストを送信
		mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"" + name + "\",\"password\":\"" + password + "\",\"verCode\":\"" + captchaText
						+ "\",\"level\":1}")
				.session(new MockHttpSession())).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0")); // ログイン成功
	}

	@Test
	public void testLoginSuccess1() throws Exception {
		// ログインリクエストを送信
		mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON)
				// .content("{\"name\":\"admin\",\"password\":\"2\",\"verCode\":\"yourVerCode\",\"level\":1}")
				.content("{\"name\":\"admin\",\"password\":\"2\",\"level\":1}").session(new MockHttpSession()))
				.andExpect(MockMvcResultMatchers.status().isOk())
				// 返されたJSONの 'code' フィールドが0であるかどうかを確認し、成功したログインを示し
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0")); 
		
	}

	@Test
	public void testLoginFailure_verCode() throws Exception {
		// 誤ったキャプチャコードを使用してログインリクエストを送信
		mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"admin\",\"password\":\"2\",\"verCode\":\"yourVerCode\",\"level\":1}")
				.session(new MockHttpSession())).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value("1001")); // ログイン失敗
	}
	
	// user
	
	@Test
	public void testAdminLoginWithValidCaptcha_User() throws Exception {
		// userテストデータ
		String name = "2";
		String password = "2";

		// リクエストとレスポンスオブジェクトを作成
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		// キャプチャコードを生成し、レスポンスオブジェクトに出力
		CaptchaUtil.out(request, response);

		// 生成されたキャプチャコードのテキストを取得する
		String captchaText = (String) request.getSession().getAttribute("captcha");

		// 正しいキャプチャコードを使用してログインリクエストを送信
		mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"" + name + "\",\"password\":\"" + password + "\",\"verCode\":\"" + captchaText
						+ "\",\"level\":3}")
				.session(new MockHttpSession())).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value("0")); // ログイン成功
	}
	
	@Test
	public void testLoginFailure_verCode_User() throws Exception {
		// 誤ったキャプチャコードを使用してログインリクエストを送信
		mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"2\",\"password\":\"2\",\"verCode\":\"eee\",\"level\":3}")
				.session(new MockHttpSession())).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value("1001")); // ログイン失敗表示
		
	}

}
