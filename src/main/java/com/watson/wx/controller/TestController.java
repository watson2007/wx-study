package com.watson.wx.controller;

import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 2023/7/7 16:02
 * @Created by hs
 */
@RestController
@RequestMapping("/test")
public class TestController {

    // 注入WxService
    private final WxMpService wxService;

    public TestController(WxMpService wxService) {
        this.wxService = wxService;
    }

    @GetMapping("/test")
    public String test() {
        return wxService.getWxMpConfigStorage().getAesKey();
    }
}
