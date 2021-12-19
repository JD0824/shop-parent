package com.mszlu.shop.app.controller;


import com.mszlu.shop.app.model.params.BuyParams;
import com.mszlu.shop.app.service.BuyService;
import com.mszlu.shop.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "BuyController测试")
@RestController
@RequestMapping("buy")
public class BuyController {

    @Autowired
    private BuyService buyService;

    @ApiOperation("buyOrder api")
    @PostMapping("submit")
    private Result submitOrder(@RequestBody BuyParams buyParams){
        return buyService.submitOrder(buyParams);
    }
}
