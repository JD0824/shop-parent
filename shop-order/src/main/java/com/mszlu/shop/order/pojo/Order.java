package com.mszlu.shop.order.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String orderId;

    private Long userId;

    private Long goodsId;

    private BigDecimal orderPrice;

    private Integer orderStatus;

    private Integer payStatus;

    private Long payTime;

    private Long createTime;


}
