package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.Admin;
import ecnu.testing.meethere.service.AdminServiceImpl;
import ecnu.testing.meethere.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminServiceImpl adminServiceImpl;
    public AdminController(AdminServiceImpl adminServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
    }

    /**
     * 管理员登录
     */
    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody Admin admin /* 此处只含有name与password信息 */, HttpSession session) {
        Result result = adminServiceImpl.login(admin);
        if (result != null) {
            /* SUCCESS CODE */
            if (result.getCode() == 200) {
                Integer adminId = adminServiceImpl.getIdByName(admin.getName());
                session.setAttribute("adminId", adminId);
            }
            return result;
        } else {
            return new Result(400,"null",null);
        }
    }
}

