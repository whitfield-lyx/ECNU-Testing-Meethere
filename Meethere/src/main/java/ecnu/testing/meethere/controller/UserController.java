package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.User;
import ecnu.testing.meethere.service.UserServiceImpl;
import ecnu.testing.meethere.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
//@SessionAttributes("userId")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * 用户登录
     */
    @RequestMapping("/login")
    @ResponseBody
    public Result Login(@RequestBody User user/*此处只含有name与password信息*/, HttpSession session){
        Result result = userServiceImpl.login(user);
        if(result.getCode()==200/*SUCCESS CODE*/){
            Integer userId = userServiceImpl.getIdByName(user.getName());
            session.setAttribute("userId",userId);
        }
        return result;
    }

    /**
     * 用户注册
     */
    @RequestMapping("/register")
    @ResponseBody
    public Result Register(@RequestBody User user) {
        userServiceImpl.save(user);
        return ResultFactory.buildSuccessResult("注册成功。");
    }

    /**
     * 用户个人信息页
     */
    @GetMapping("/info")
    public User UserInfo(@SessionAttribute Integer userId){
        return userServiceImpl.selectByKey(userId);
    }

    /**
     * 用户修改密码
     */
    @RequestMapping("/info")
    public int updatePassword(@SessionAttribute Integer userId, @RequestBody String password){
        return userServiceImpl.updatePassword(userId, password);
    }

}
