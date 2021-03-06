package com.zhong.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.channels.FileChannel;

@RestController
public class HelloController {
    @Value("${com.zhong.helloWorld}")
    private String helloWorld;

    public String getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }

    @RequestMapping("/hello")
    public String hello(){
        return helloWorld;
    }

    @RequestMapping("/hello2")
    public String hello2(ModelMap map){
        map.addAttribute("contenct",helloWorld);
        return "hello2";
    }
}
