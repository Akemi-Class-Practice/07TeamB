package com.example.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.common.Result;

import com.example.entity.Account;
import com.example.entity.ClassInfo;
import com.example.entity.InquiryInfo;
import com.example.service.InquiryInfoService;
import java.util.List;


@RestController
@RequestMapping("/inquiryInfo")
public class InquiryInfoController {

    @Resource
    private InquiryInfoService inquiryInfoService;


    @PostMapping
    public Result add(@RequestBody InquiryInfo inquiryInfo) {
        inquiryInfoService.add(inquiryInfo);
        return Result.success();
    }

    
    @GetMapping
    public Result findAll() {
        List<InquiryInfo> list = inquiryInfoService.findAll();
        return Result.success(list);
    }

}
