package com.watson.wx.config;

import com.binarywang.spring.starter.wxjava.mp.properties.WxMpProperties;
import com.watson.wx.handler.LogHandler;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname WxMpConfiguration
 * @Description TODO
 * @Date 2023/7/13 15:43
 * @Created by hs
 */
@AllArgsConstructor
@Configuration
@EnableConfigurationProperties(WxMpProperties.class)
public class WxMpConfiguration {

    private final LogHandler logHandler;

    @Bean
    public WxMpMessageRouter messageRouter(WxMpService wxMpService ) {
        final WxMpMessageRouter newRouter = new WxMpMessageRouter(wxMpService);

        // 记录所有事件的日志 （异步执行）
        newRouter.rule().handler(logHandler).next();

        return newRouter;
    }
}
