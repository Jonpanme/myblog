package com.mp.service;

import com.mp.po.User;

//server层主要用于写相关逻辑

public interface UserService {
    User checkUser(String username,String password);
}
