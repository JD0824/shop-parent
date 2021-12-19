package com.mszlu.shop.common.vo.OrderParams;

import java.math.BigDecimal;

/**
 * @author 86131
 * date 2021/12/16 20:07:00
 * @description
 */
public class OrderParams {

    private Long userId;
    private Long goodsId;
    private BigDecimal goodsPrice;

    public OrderParams() {
    }

    public OrderParams(Long userId, Long goodsId, BigDecimal goodsPrice) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.goodsPrice = goodsPrice;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
