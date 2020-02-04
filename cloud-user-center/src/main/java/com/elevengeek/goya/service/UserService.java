package com.elevengeek.goya.service;

import com.elevengeek.goya.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author cj
 * @create 2020-02-04-18:03
 */
@FeignClient(name="cloud-user")
public interface UserService {

    @GetMapping("{id}")
    UserDto getUser(@PathVariable String id);
}