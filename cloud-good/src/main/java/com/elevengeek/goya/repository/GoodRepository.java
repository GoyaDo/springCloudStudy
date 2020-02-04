package com.elevengeek.goya.repository;

import com.elevengeek.goya.entity.CGoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cj
 * @create 2020-02-04-17:36
 */
public interface GoodRepository extends JpaRepository<CGoodEntity,String> {
}