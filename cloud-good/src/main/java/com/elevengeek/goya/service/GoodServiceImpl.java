package com.elevengeek.goya.service;

import com.elevengeek.goya.entity.CGoodEntity;
import com.elevengeek.goya.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cj
 * @create 2020-02-04-17:37
 */
@Service
public class GoodServiceImpl {

    @Autowired
    private GoodRepository goodRepository;

    /**
     * @description 查询商品
     * @param [id]
     * @return com.elevengeek.goya.entity.CGoodEntity
     */
    public CGoodEntity getGood(String id){
        if(!goodRepository.existsById(id)){
            return null;
        }
        return goodRepository.findById(id).get();
    }

    /**
     * @description 保存商品
     * @param [cGoodEntity]
     * @return com.elevengeek.goya.entity.CGoodEntity
     */
    public CGoodEntity saveGood(CGoodEntity cGoodEntity){
        return goodRepository.save(cGoodEntity);
    }

}