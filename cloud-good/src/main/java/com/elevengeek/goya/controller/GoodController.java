package com.elevengeek.goya.controller;

import com.elevengeek.goya.entity.CGoodEntity;
import com.elevengeek.goya.service.GoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author cj
 * @create 2020-02-04-17:38
 */
@RestController
@RequestMapping("good")
public class GoodController {

    @Autowired
    private GoodServiceImpl goodService;

    /**
     * @description 查询商品
     * @param [id]
     * @return com.elevengeek.goya.entity.CGoodEntity
     */
    @GetMapping("{id}")
    public CGoodEntity getGood(@PathVariable String id){
        return goodService.getGood(id);
    }

    /**
     * @description 保存商品
     * @param [cGoodEntity]
     * @return com.elevengeek.goya.entity.CGoodEntity
     */
    @PostMapping
    public CGoodEntity saveGood(@RequestBody CGoodEntity cGoodEntity){
        return goodService.saveGood(cGoodEntity);
    }
}