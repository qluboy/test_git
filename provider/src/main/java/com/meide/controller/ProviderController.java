package com.meide.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {


    @Value("${server.port}")
    private String port;


    @GetMapping("/index")
    public String index(){
        return "当前调用的Provider服务端口为："+this.port;
    }
}
