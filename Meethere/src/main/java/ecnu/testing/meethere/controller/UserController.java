package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.User;
import ecnu.testing.meethere.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/login")
    @ResponseBody
    public String Login(@RequestBody User user, Map<String,Object> map){
        Integer id = user.getUserId();
        System.out.println("user id is "+id+" password is "+user.getPassword());
        User myUser = userServiceImpl.selectByKey(id);
        if(myUser==null){
            map.put("msg", "不存在此用户名的账号!");
            return "fail";
        }
        if(!myUser.getPassword().equals(user.getPassword())){
            map.put("msg", "密码或账号错误!");
            return "fail";
        }else {
            map.put("msg", "登录成功");
            return "success";
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public String Register(@RequestBody User user,Map<String,Object> map) {
        userServiceImpl.save(user);
        map.put("msg","注册成功");
        return "success";
    }

}
