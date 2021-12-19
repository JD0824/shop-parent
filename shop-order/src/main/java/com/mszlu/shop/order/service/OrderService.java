package com.mszlu.shop.order.service;


import com.mszlu.shop.common.vo.OrderParams.OrderParams;
import com.mszlu.shop.common.vo.Result;

public interface OrderService {

    public Result createOrder(OrderParams orderParams);
}