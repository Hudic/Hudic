package com.Hudic.service;

import com.Hudic.model.User;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

/**
 * jiangcq
 * 2018/12/7 14:40
 */
@Service
public interface UserService {
    public JSONObject register(User user);

    public JSONObject login(User user);
}
