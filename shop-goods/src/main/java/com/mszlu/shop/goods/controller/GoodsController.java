package com.mszlu.shop.goods.controller;


import com.mszlu.shop.common.vo.Result;
import com.mszlu.shop.common.vo.goods.GoodsBO;
import com.mszlu.shop.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("findGoods/{id}")
    public Result<GoodsBO> findGoods(@PathVariable("id") Long id){
        return goodsService.findGoodsById(id);
    }
}
