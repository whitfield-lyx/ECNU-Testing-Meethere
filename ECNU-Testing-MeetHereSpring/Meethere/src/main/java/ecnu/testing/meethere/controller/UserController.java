package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.User;
import ecnu.testing.meethere.service.UserServiceImpl;
import ecnu.testing.meethere.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    @ResponseBody
    public Result Login(@RequestBody User user /* 此处只含有name与password信息 */, HttpSession session){
        Result result = userServiceImpl.login(user);
        if(result.getCode()==200 /* SUCCESS CODE */){
            Integer userId = userServiceImpl.getIdByName(user.getName());
            session.setAttribute("userId",userId);
        }
        return result;
    }

    /**
     * 用户注册
     */
    @PostMapping("/register")
    @ResponseBody
    public Result Register(@RequestBody User user) {
        return userServiceImpl.save(user);
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
    @PostMapping("/info")
    public int updatePassword(@SessionAttribute Integer userId, @RequestBody User user){
        /* 仅修改 password 字段 */
        return userServiceImpl.updatePassword(userId, user);
    }

    /**
     * 显示所有用户信息
     */
    @GetMapping("/userInfo")
    public List<User> UserInfo(){
        return userServiceImpl.selectAllUser();
    }

    /**
     * 管理员修改/重置用户密码
     */
    @PostMapping("/userInfo")
    public int updatePassword(@RequestBody User user){
        /* 仅修改 password 字段 */
        return userServiceImpl.updatePasswordByAdmin(user);
    }
}
