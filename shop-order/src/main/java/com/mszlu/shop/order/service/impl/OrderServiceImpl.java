package com.mszlu.shop.order.service.impl;


import com.mszlu.shop.common.vo.OrderParams.OrderParams;
import com.mszlu.shop.common.vo.Result;
import com.mszlu.shop.order.mapper.OrderMapper;
import com.mszlu.shop.order.pojo.Order;
import com.mszlu.shop.order.service.OrderService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Result createOrder(OrderParams orderParams) {
        Order order = new Order();
        order.setCreateTime(System.currentTimeMillis());
        order.setGoodsId(orderParams.getGoodsId());
        order.setUserId(orderParams.getUserId());
        order.setOrderPrice(orderParams.getGoodsPrice());
        order.setOrderId(System.currentTimeMillis()+""+orderParams.getUserId()+ ""+RandomUtils.nextInt(1000,9999));
        order.setOrderStatus(0);
        order.setPayStatus(0);
        order.setPayTime(-1L);
        this.orderMapper.insert(order);
        return Result.success(order.getOrderId());
    }
}
