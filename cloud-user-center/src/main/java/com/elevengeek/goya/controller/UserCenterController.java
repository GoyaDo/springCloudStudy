package com.elevengeek.goya.controller;

import com.elevengeek.goya.dto.OrderDto;
import com.elevengeek.goya.dto.UserDto;
import com.elevengeek.goya.service.OrderService;
import com.elevengeek.goya.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cj
 * @create 2020-02-04-18:00
 *
 * @DefaultProperties(defaultFallback = “fallback”) 这个是默认回退注解
 * execution.isolation.thread.timeoutInMilliseconds 此属性设置调用者观察超时并离开命令执行的时间（以毫秒为单位）
 * coreSize 此属性设置核心线程池大小
 * maxQueueSize 此属性设置实现的最大队列大小
 * keepAliveTimeMinutes 此属性设置保持活动时间，以分钟为单位
 * queueSizeRejectionThreshold 此属性设置队列大小拒绝阈值
 * metrics.rollingStats.numBuckets 度量统计属性
 * metrics.rollingStats.timeInMilliseconds 此属性设置统计滚动窗口的持续时间（以毫秒为单位）
 */
@RestController
@DefaultProperties(defaultFallback = "fallback")
public class UserCenterController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    /**
     * @description 获取当前用户的订单列表
     * @param []
     * @return java.util.List<com.elevengeek.goya.dto.OrderDto>
     */
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="500")
    },threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "30"),
            @HystrixProperty(name = "maxQueueSize", value = "101"),
            @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
            @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
    })
    @GetMapping("userOrderList/{userId}")
    public Object getUserOrderList(@PathVariable String userId){
        Map<String,Object> resultMap=new HashMap<>();
        List<OrderDto> orderDtoList=orderService.getUserOrderList(userId);
        UserDto userDto=userService.getUser(userId);
        resultMap.put("user",userDto);
        resultMap.put("orderList",orderDtoList);
        return resultMap;
    }

    private Object error(String userId) {
        return "请求出错";
    }

    private Object fallback(){
        return "错误";
    }
}