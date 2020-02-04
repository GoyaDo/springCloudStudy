package com.elevengeek.goya.repository;

import com.elevengeek.goya.entity.COrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author cj
 * @create 2020-02-04-17:23
 */
public interface OrderRepository extends JpaRepository<COrderEntity,String> {
    /**
     * @description 查询该用户的所有订单
     * @param [createBy]
     * @return java.util.List<com.elevengeek.goya.entity.COrderEntity>
     */
    List<COrderEntity> findByCreateByOrderByCreateDate(String createBy);
}
