package com.elevengeek.goya.controller;

import com.elevengeek.goya.entity.COrderEntity;
import com.elevengeek.goya.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cj
 * @create 2020-02-04-17:24
 */
@RestController
@RefreshScope
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

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
     * @description 获取订单
     * @param [id]
     * @return com.elevengeek.goya.entity.COrderEntity
     */
    @GetMapping("{id}")
    public COrderEntity getOrder(@PathVariable String id){
        return orderService.getOrder(id);
    }

    /**
     * @description 新增订单
     * @param [orderEntity]
     * @return com.elevengeek.goya.entity.COrderEntity
     */
    @PostMapping
    public COrderEntity saveOrder(@RequestBody COrderEntity COrderEntity){
        return orderService.saveOrder(COrderEntity);
    }
    /**
     * @description 通过用户Id查询用户订单列表
     * @param [userId]
     * @return java.util.List<com.elevengeek.goya.entity.COrderEntity>
     */
    @GetMapping("userOrderList/{userId}")
    public List<COrderEntity> getOrderListByUser(@PathVariable String userId){
        return orderService.getOrderListByUser(userId);
    }
}
