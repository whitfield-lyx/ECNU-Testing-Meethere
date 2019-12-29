package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.Admin;
import ecnu.testing.meethere.service.AdminService;
import ecnu.testing.meethere.service.AdminServiceImpl;
import ecnu.testing.meethere.service.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
class AdminControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AdminServiceImpl adminServiceImpl;

    @MockBean
    AdminService adminService;

    @MockBean
    UserServiceImpl userServiceImpl;

    @Test
    @DisplayName("Testing login()")
    void login() throws Exception{
        Admin admin=new Admin();
        admin.setName("user01");
        admin.setPassword("111111");
        admin.setAdminId(1);
        ResultActions perform=mockMvc.perform(post("/api/admin/login"));
        perform.andExpect(status().isOk());
        verify(adminServiceImpl,times(1)).login(admin);
        verify(adminServiceImpl,times(1)).getIdByName(admin.getName());
    }
}
