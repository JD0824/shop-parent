package com.mszlu.shop.app.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mszlu.shop.app.model.params.BuyParams;
import com.mszlu.shop.app.service.BuyService;
import com.mszlu.shop.common.vo.OrderParams.OrderParams;
import com.mszlu.shop.common.vo.Result;
import com.mszlu.shop.common.vo.goods.GoodsBO;
import com.mszlu.shop.common.vo.user.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class BuyServiceImpl implements BuyService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Result submitOrder(BuyParams buyParams) {
        String userResult = restTemplate.getForObject("http://localhost:8001/user/findUser/" + buyParams.getUserId(), String.class);
        Result<UserBO> userBOResult = JSON.parseObject(userResult,new TypeReference<Result<UserBO>>(){});
        if (userBOResult == null || !userBOResult.isSuccess() || userBOResult.getData() == null){
            return Result.fail(10001,"用户不存在");
        }
        UserBO userBO = userBOResult.getData();

        String goodsResult = restTemplate.getForObject("http://localhost:8002/goods/findGoods/" + buyParams.getGoodsId(), String.class);
        Result<GoodsBO> goodsBOResult = JSON.parseObject(goodsResult,new TypeReference<Result<GoodsBO>>(){});

        if (goodsBOResult == null || !goodsBOResult.isSuccess() || goodsBOResult.getData() == null){
            return Result.fail(10002,"商品不存在");
        }
        GoodsBO goodsBO = (GoodsBO) goodsBOResult.getData();
        Integer goodsStock = goodsBO.getGoodsStock();
        if (goodsStock < 0){
            return Result.fail(10003,"商品库存不足");
        }
        BigDecimal goodsPrice = goodsBO.getGoodsPrice();
        BigDecimal account = userBO.getAccount();
        if (account.compareTo(goodsPrice) < 0){
            return Result.fail(10004,"余额不足");
        }
        OrderParams orderParams = new OrderParams();
        orderParams.setUserId(userBO.getId());
        orderParams.setGoodsId(goodsBO.getId());
        orderParams.setGoodsPrice(goodsBO.getGoodsPrice());
        String orderResult = restTemplate.postForObject("http://localhost:8003/order/createOrder", orderParams, String.class);
        Result<String> orderResultString = JSON.parseObject(orderResult,new TypeReference<Result<String>>(){});
        if (orderResultString == null || !orderResultString.isSuccess()){
            return Result.fail(10005,"下单失败");
        }
        String orderId =  orderResultString.getData();

        return Result.success(orderId);
    }
}
