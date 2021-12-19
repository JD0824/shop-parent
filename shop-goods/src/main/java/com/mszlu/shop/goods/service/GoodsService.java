package com.mszlu.shop.goods.service;


import com.mszlu.shop.common.vo.Result;
import com.mszlu.shop.common.vo.goods.GoodsBO;

public interface GoodsService {

    Result<GoodsBO> findGoodsById(Long id);
}