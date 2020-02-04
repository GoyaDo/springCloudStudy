package com.elevengeek.goya.controller;

import com.elevengeek.goya.entiy.UserEntity;
import com.elevengeek.goya.repository.UserRepository;
import com.elevengeek.goya.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author cj
 * @create 2020-02-04-16:39
 */

@RestController
@RefreshScope
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Value("${envName}")
    private String envName;

    /**
     * @description 环境配置获取
     * @param []
     * @return java.lang.String
     */
    @GetMapping("getEnvName")
    public String getEnvName(){
        return envName;
    }

    /**
     * @description 获取用户
     * @param [id]
     * @return com.elevengeek.goya.entiy.UserEntity
     */
    @GetMapping("{id}")
    public UserEntity getUser(@PathVariable String id) throws InterruptedException {
//        Thread.sleep(600);
//        int c=2/0;
        return userService.getUser(id);
    }

    /**
     * @description 保存用户
     * @param [userEntity]
     * @return com.elevengeek.goya.entiy.UserEntity
     */
    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity userEntity){
        return userService.saveUser(userEntity);
    }
}
