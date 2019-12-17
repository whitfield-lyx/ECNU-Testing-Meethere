package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.User;
import ecnu.testing.meethere.service.UserServiceImpl;
import ecnu.testing.meethere.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/login")
    @ResponseBody
    public Result Login(@RequestBody User user){
        return userServiceImpl.login(user);
    }

    @RequestMapping("/register")
    @ResponseBody
    public Result Register(@RequestBody User user) {
        userServiceImpl.save(user);
        return ResultFactory.buildSuccessResult("注册成功。");
    }

}
