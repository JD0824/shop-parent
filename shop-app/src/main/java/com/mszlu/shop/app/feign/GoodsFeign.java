package com.mszlu.shop.app.feign;


import com.mszlu.shop.common.vo.Result;
import com.mszlu.shop.common.vo.goods.GoodsBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("shop-goods")
public interface GoodsFeign {

    //调用路径同http访问路径
    @GetMapping("/goods/findGoods/{id}")
    public Result<GoodsBO> findGoods(@PathVariable("id") Long id);
}
