package com.mszlu.shop.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Goods {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String goodsName;

    private BigDecimal goodsPrice;

    private Integer goodsStock;

    private Long createTime;
}
