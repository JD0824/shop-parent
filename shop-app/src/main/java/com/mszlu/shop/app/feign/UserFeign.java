package com.mszlu.shop.app.feign;

import com.mszlu.shop.common.vo.Result;
import com.mszlu.shop.common.vo.user.UserBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("shop-user")
public interface UserFeign {

    //调用路径同http访问路径
    @GetMapping("/user/findUser/{id}")
    public Result<UserBO> findUser(@PathVariable("id") Long id);
}
