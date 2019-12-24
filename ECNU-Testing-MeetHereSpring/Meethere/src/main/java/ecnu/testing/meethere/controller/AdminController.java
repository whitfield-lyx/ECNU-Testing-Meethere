package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.Admin;
import ecnu.testing.meethere.service.AdminServiceImpl;
import ecnu.testing.meethere.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminServiceImpl;

    /**
     * 管理员登录
     */
    @PostMapping("/login")
    @ResponseBody
    public Result Login(@RequestBody Admin admin /* 此处只含有name与password信息 */, HttpSession session){
        Result result = adminServiceImpl.login(admin);
        if(result.getCode()==200 /* SUCCESS CODE */){
            Integer adminId = adminServiceImpl.getIdByName(admin.getName());
            session.setAttribute("adminId", adminId);
        }
        return result;
    }
}