package com.mszlu.shop.user.service;


import com.mszlu.shop.common.vo.Result;
import com.mszlu.shop.common.vo.user.UserBO;

public interface UserService {

    Result<UserBO> findUser(Long id);
}
