package com.mszlu.shop.user.controller;


import com.mszlu.shop.common.vo.Result;
import com.mszlu.shop.common.vo.user.UserBO;
import com.mszlu.shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("findUser/{id}")
    public Result<UserBO> findUser(@PathVariable("id") Long id){
        return userService.findUser(id);
    }
}
