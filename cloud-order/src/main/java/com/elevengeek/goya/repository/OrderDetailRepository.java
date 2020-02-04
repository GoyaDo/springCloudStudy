package com.elevengeek.goya.repository;

import com.elevengeek.goya.entity.COrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cj
 * @create 2020-02-04-17:22
 */
public interface OrderDetailRepository extends JpaRepository<COrderDetailEntity,String> {
}
