package com.xiaolhe.shiro.web.controller;

import com.xiaolhe.shiro.web.common.ResponseResult;
import com.xiaolhe.shiro.web.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *     用户登录
 * </p>
 * @author: 陆袆 >_<
 * @email: amixiao@qq.com
 * @createTime: 2020-09-04  15:07
 */
@Controller
@Slf4j
public class UserController {


    @RequestMapping(value = "/sublogin",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String sublogin(User user){
        //1.获取主体
        Subject subject = SecurityUtils.getSubject();
        //2.主体提交请求
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.getMessage();
            return "登录异常";
        }
        return "登录成功";
    }
}
