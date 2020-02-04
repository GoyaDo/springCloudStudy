package com.elevengeek.goya.service;

import com.elevengeek.goya.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author cj
 * @create 2020-02-04-18:02
 */
@FeignClient(name="cloud-order")
public interface OrderService {

    /**
     * @description 获取用户订单列表
     * @param [userId]
     * @return java.util.List<com.elevengeek.goya.dto.OrderDto>
     */
    @GetMapping("userOrderList/{userId}")
    List<OrderDto> getUserOrderList(@PathVariable String userId);
}