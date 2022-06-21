package com.electronicticket.controller;

import com.electronicticket.domain.ResultData;
import com.electronicticket.domain.User;
import com.electronicticket.services.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.val;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @desc
 * @date 2022年02月19日 2022/2/19
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private User user;

    @RequestMapping("login")
    public ResultData userLogin(@RequestBody JSONObject request){
        System.out.println(request);
        System.out.println(request.toString());
        String userName = request.getString("userName");
        String passWord = request.getString("passWord");
        int code = -1;
        String msg = "";
        Object data = null;
        val userByUserName = userService.findUserByUserName(userName);
        if (userByUserName != null) {
            if (userByUserName.getPassWord().equals(passWord)) {
                code = 200;
                msg = "登陆成功";
                data = userByUserName;
            } else {
                code = 200;
                msg = "密码错误";
            }
        } else {
            code = 400;
            msg = "用户名不存在";
        }
        ResultData response = new ResultData();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    @RequestMapping("info")
    public ResultData info(@RequestBody JSONObject request){
        String userName = request.getString("userName");
        int code = -1;
        String msg = "";
        Object data = null;
        val userByUserName = userService.findUserByUserName(userName);
        if (userByUserName != null) {
            code = 200;
            msg = "登陆成功";
            data = userByUserName;
        } else {
            code = 400;
            msg = "用户名不存在";
        }
        ResultData response = new ResultData();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    @RequestMapping("user")
    public User getUser(){
        return user;
    }
}
