package com.elevengeek.goya.service;

import com.elevengeek.goya.entity.COrderEntity;
import com.elevengeek.goya.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cj
 * @create 2020-02-04-17:24
 */
@Service
public class OrderServiceImpl {
    @Autowired
    private OrderRepository orderRepository;

    /**
     * @description 通过订单Id获取订单
     * @param [id]
     * @return com.elevengeek.goya.entity.COrderEntity
     */
    public COrderEntity getOrder(String id){
        if(!orderRepository.existsById(id)){
            return null;
        }
        return orderRepository.findById(id).get();
    }

    /**
     * @description 保存订单
     * @param [orderEntity]
     * @return com.elevengeek.goya.entity.COrderEntity
     */
    public COrderEntity saveOrder(COrderEntity COrderEntity){
        COrderEntity.setOrderNo(String.valueOf(System.currentTimeMillis()));
        return orderRepository.save(COrderEntity);
    }

    /**
     * @description 获取用户下的订单
     * @param [userId]
     * @return java.util.List<com.elevengeek.goya.entity.COrderEntity>
     */
    public List<COrderEntity> getOrderListByUser(String userId){
        return orderRepository.findByCreateByOrderByCreateDate(userId);
    }
}
