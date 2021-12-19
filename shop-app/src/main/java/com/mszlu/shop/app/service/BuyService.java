package com.mszlu.shop.app.service;


import com.mszlu.shop.app.model.params.BuyParams;
import com.mszlu.shop.common.vo.Result;

public interface BuyService {
    Result submitOrder(BuyParams buyParams);
}
