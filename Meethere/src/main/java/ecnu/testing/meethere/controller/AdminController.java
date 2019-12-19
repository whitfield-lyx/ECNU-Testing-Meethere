package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.Admin;
import ecnu.testing.meethere.service.AdminServiceImpl;
import ecnu.testing.meethere.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @PostMapping("/login")
    @ResponseBody
    public Result Login(@RequestBody Admin admin){
        return adminServiceImpl.login(admin);
    }
}
