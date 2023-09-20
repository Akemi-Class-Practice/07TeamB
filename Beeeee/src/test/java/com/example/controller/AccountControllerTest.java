package com.example.controller;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

import com.example.entity.Account;
import com.example.service.AdminInfoService; 
import com.example.service.YuuzaInfoService; 

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminInfoService adminInfoService; // 替换成实际的Service类

    @Test
    public void testLogin() throws Exception {
        // 模拟Service方法的行为，根据您的实际需求进行配置
        when(adminInfoService.login("testUser", "hashedPassword")).thenReturn(new Account());

        // 模拟请求参数
        String requestBody = "{\"name\":\"testUser\",\"password\":\"hashedPassword\",\"verCode\":\"12345\",\"level\":1}";

        // 发起POST请求
        mockMvc.perform(post("/login")
                .content(requestBody)
                .contentType("application/json"))
                .andExpect(status().isOk());

        // 根据实际需求进行断言，这里只是验证HTTP状态码
    }
}
