package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.Admin;
import ecnu.testing.meethere.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @RequestMapping("/login")
    @ResponseBody
    public String Login(@RequestBody Admin admin, Map<String,Object> map){
        Integer id = admin.getAdminId();
        System.out.println("admin id is "+id+" password is "+admin.getPassword());
        Admin myAdmin = adminServiceImpl.selectByKey(id);
        if(myAdmin==null){
            map.put("msg", "不存在此用户名的账号!");
            return "fail";
        }
        if(!myAdmin.getPassword().equals(admin.getPassword())){
            map.put("msg", "密码或账号错误!");
            return "fail";
        }else {
            map.put("msg", "登录成功");
            return "success";
        }
    }
}
