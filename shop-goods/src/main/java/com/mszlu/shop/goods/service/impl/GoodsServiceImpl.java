package com.mszlu.shop.goods.service.impl;


import com.mszlu.shop.common.vo.Result;
import com.mszlu.shop.common.vo.goods.GoodsBO;
import com.mszlu.shop.goods.mapper.GoodsMapper;
import com.mszlu.shop.goods.pojo.Goods;
import com.mszlu.shop.goods.service.GoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Result<GoodsBO> findGoodsById(Long id) {
        Goods goods = goodsMapper.selectById(id);
        GoodsBO goodsBO = new GoodsBO();
        BeanUtils.copyProperties(goods,goodsBO);
        return Result.success(goodsBO);
    }
}
