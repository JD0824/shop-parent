package com.mszlu.shop.app.feign;


import com.mszlu.shop.common.vo.OrderParams.OrderParams;
import com.mszlu.shop.common.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("shop-order")
public interface OrderFeign {

    //调用路径同http访问路径
    @PostMapping("/order/createOrder")
    public Result<String> createOrder(@RequestBody OrderParams orderParams);
}
