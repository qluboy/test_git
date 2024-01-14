package com.meide.controller;

import com.meide.feign.CustomerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class CustomerContrioller {

    /**
     * nacos自带的一个发现服务的组件 主要是寻找nacos上的服务
     *//*
    @Autowired
    private DiscoveryClient discoveryClient;

    *//**
     * 调用服务的注入
     *//*
    @Autowired
    private RestTemplate restTemplate;

    *//**
     * 1、发现服务操作、2、调用操作
     * @return
     *//*
    @GetMapping("/instance")
    public String instance(){
//        通过名字直接找到服务就可以
//        serverId 就是nacos上的服务器名字
        List<ServiceInstance> provider = this.discoveryClient.getInstances("provider");
        int index = ThreadLocalRandom.current().nextInt(provider.size());
//        随机获取一个服务实例
        ServiceInstance serviceInstance = provider.get(index);
//        调用实例 用restTemplate
        *//**
         * 通过获取到serviceInstance这个服务实例的名字，就可以调用getUri方法来获取其路径前缀
         *//*
        String forObject = this.restTemplate.getForObject(serviceInstance.getUri() + "/index", String.class);
        return "当前customer实例调用provider成功，结果为"+forObject;
    }*/


    @Autowired
    private CustomerFeign customerFeign;


    @GetMapping("/instance")
    public String instance(){
        String index = customerFeign.index();
        return "customer调用provider成功，结果是："+index;
    }

}
