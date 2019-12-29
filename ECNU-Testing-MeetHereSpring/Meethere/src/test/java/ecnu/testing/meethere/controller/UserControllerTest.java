package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.User;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserServiceImpl userServiceImpl;

    @Test
    @DisplayName("Testing Login()")
    void Login() throws Exception {
        User user = new User();
        user.setName("user01");
        user.setPassword("apple");
        ResultActions perform=mockMvc.perform(post("/api/user"));
        perform.andExpect(status().isOk());
        verify(userServiceImpl,times(1)).login(user);
    }

    @Test
    @DisplayName("Testing Register()")
    void Register() throws Exception {
        User user = new User();
        user.setName("user01");
        user.setPassword("apple");
        user.setNickname("1231asda");
        user.setUserId(5);
        ResultActions perform=mockMvc.perform(post("/api/register"));
        perform.andExpect(status().isOk());
        verify(userServiceImpl,times(1)).save(user);
    }

    @Test
    @DisplayName("Testing UserInfo()")
    void getUserInfo() throws Exception {
        ResultActions perform=mockMvc.perform(get("/api/info"));
        perform.andExpect(status().isOk());
        verify(userServiceImpl,times(1)).selectByKey(5);
    }

    @Test
    @DisplayName("Testing updatePassword()")
    void updatePassword() throws Exception {
        User user = new User();
        user.setName("user01");
        user.setPassword("apple");
        user.setNickname("1231asda");
        user.setUserId(5);
        ResultActions perform=mockMvc.perform(post("/api/info"));
        perform.andExpect(status().isOk());
        verify(userServiceImpl,times(1)).updatePassword(5,user);
    }

    @Test
    @DisplayName("Testing UserInfo()")
    void UserInfo() throws Exception {
        ResultActions perform=mockMvc.perform(get("/api/userInfo"));
        perform.andExpect(status().isOk());
        verify(userServiceImpl,times(1)).selectAllUser();
    }

    @Test
    @DisplayName("Testing updatePassword()")
    void updatePassword2() throws Exception {
        User user = new User();
        user.setName("user01");
        user.setPassword("apple");
        user.setNickname("1231asda");
        user.setUserId(5);
        ResultActions perform=mockMvc.perform(post("/api/userInfo"));
        perform.andExpect(status().isOk());
        verify(userServiceImpl,times(1)).updatePasswordByAdmin(user);
    }

}
