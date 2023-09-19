package com.example.controller;

import com.example.common.Result;
import com.example.entity.YuuzaInfo;
import com.example.service.YuuzaInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/yuuzaInfo")

public class YuuzaInfoController {

    @Resource
    private YuuzaInfoService yuuzaInfoService;

    @PostMapping
    public Result add(@RequestBody YuuzaInfo yuuzaInfo) {
        yuuzaInfoService.add(yuuzaInfo);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody YuuzaInfo yuuzaInfo) {
        yuuzaInfoService.update(yuuzaInfo);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        List<YuuzaInfo> list = yuuzaInfoService.finAll();
        return Result.success(list);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        yuuzaInfoService.deleteById(id);
        return Result.success();
    }

}
