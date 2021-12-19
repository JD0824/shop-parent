package com.mszlu.shop.user.service.impl;

import com.mszlu.shop.common.vo.Result;
import com.mszlu.shop.common.vo.user.UserBO;
import com.mszlu.shop.user.mapper.UserMapper;
import com.mszlu.shop.user.pojo.User;
import com.mszlu.shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<UserBO> findUser(Long id) {
        User user = userMapper.selectById(id);
        if (user == null){
            return Result.success(null);
        }
        UserBO userBO = new UserBO();
        userBO.setAccount(user.getAccount());
        userBO.setId(user.getId());
        return Result.success(userBO);
    }
}
