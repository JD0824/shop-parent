package com.mszlu.shop.app.service.impl;

import com.mszlu.shop.app.feign.GoodsFeign;
import com.mszlu.shop.app.feign.OrderFeign;
import com.mszlu.shop.app.feign.UserFeign;
import com.mszlu.shop.app.model.params.BuyParams;
import com.mszlu.shop.app.service.BuyService;
import com.mszlu.shop.common.vo.OrderParams.OrderParams;
import com.mszlu.shop.common.vo.Result;
import com.mszlu.shop.common.vo.goods.GoodsBO;
import com.mszlu.shop.common.vo.user.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BuyServiceImpl implements BuyService {
    @Autowired
    private UserFeign userFeign;
    @Autowired
    private GoodsFeign goodsFeign;
    @Autowired
    private OrderFeign orderFeign;

    @Override
    public Result submitOrder(BuyParams buyParams) {
        Result<UserBO> userBOResult = userFeign.findUser(buyParams.getUserId());
        if (userBOResult == null || !userBOResult.isSuccess() || userBOResult.getData() == null){
            return Result.fail(10001,"用户不存在");
        }
        UserBO userBO = userBOResult.getData();

        Result<GoodsBO> goodsBOResult = goodsFeign.findGoods(buyParams.getGoodsId());

        if (goodsBOResult == null || !goodsBOResult.isSuccess() || goodsBOResult.getData() == null){
            return Result.fail(10002,"商品不存在");
        }
        GoodsBO goodsBO = goodsBOResult.getData();
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
        Result<String> orderResultString = orderFeign.createOrder(orderParams);

        if (orderResultString == null || !orderResultString.isSuccess()){
            return Result.fail(10005,"下单失败");
        }
        String orderId =  orderResultString.getData();

        return Result.success(orderId);
    }
}
