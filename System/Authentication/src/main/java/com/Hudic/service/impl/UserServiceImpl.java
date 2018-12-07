package com.Hudic.service.impl;

import com.Hudic.dao.UserRepository;
import com.Hudic.model.User;
import com.Hudic.service.UserService;
import com.Hudic.util.Tool;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * jiangcq
 * 2018/12/7 14:41
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public JSONObject register(User user) {
        JSONObject ret = new JSONObject();
        int checkResult = (int) Tool.checkNecessaryParams(user, "username", "password").get("status");
        if (checkResult == -1) {
            return Tool.buildBadRequestResult(user);
        }
        if (checkResult == 0) {

        }
        String username = user.getUsername();
        String password = user.getPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            ret.put("status", -1);//-1请求有问题
            ret.put("msg", "Bad request");
            return ret;
        }
        return null;
    }

    @Override
    public JSONObject login(User user) {
        JSONObject ret = new JSONObject();
        //检查是否缺失必要参数
        JSONObject checkResult = Tool.checkNecessaryParams(user, "username", "password");
        if ((int) checkResult.get("status") == 0) {
            return ret;
        }
//        String username = user.getUsername();
//        String password = user.getPassword();
//        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
//            ret.put("status", -1);//-1传入数据有问题
//            ret.put("msg", "Bad request");
//            return ret;
//        }
        User repositoryUser = userRepository.findOne(user.getUsername());
        if (user.getPassword().equals(repositoryUser.getPassword())) {
            ret.put("status", 1);//1操作成功,通过
            ret.put("msg", "Login success");
            ret.put("data", Tool.parseToJsonString(user));//把参数携带回去
        } else {
            ret.put("status", 0);//0操作失败，不通过
            ret.put("msg", "Login failed");
        }
        return ret;
    }


//    private <T> JSONObject checkNotNullParams(T t, String... params) {
//        JSONObject jsonObject = JSONObject.parseObject(Tool.parseToJsonString(t));
//        JSONObject ret = new JSONObject();
//        List<String> nullParams = new ArrayList<>();
//        for (String param : params) {
//            if (jsonObject.get(param) == null) {
//                nullParams.add(param);
//            }
//        }
//        ret.put("staus", 1);
//        ret.put("nullParams", nullParams);
//        return ret;
//    }

}
