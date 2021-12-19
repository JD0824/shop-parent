package com.mszlu.shop.order.controller;


import com.mszlu.shop.common.vo.OrderParams.OrderParams;
import com.mszlu.shop.common.vo.Result;
import com.mszlu.shop.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("createOrder")
    public Result<OrderParams> createOrder(@RequestBody OrderParams orderParams){
        return orderService.createOrder(orderParams);
    }
}
