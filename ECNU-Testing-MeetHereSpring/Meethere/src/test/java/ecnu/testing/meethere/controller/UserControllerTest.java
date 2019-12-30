package ecnu.testing.meethere.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import ecnu.testing.meethere.model.User;
import ecnu.testing.meethere.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {
    private MockMvc mockMvc;

    private UserServiceImpl userServiceImpl;
    private MockHttpSession session;

    @BeforeEach
    void  setUp(){
        userServiceImpl = mock(UserServiceImpl.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userServiceImpl)).build();
        session = new MockHttpSession();
    }

    @Test
    @DisplayName("happy_path_testing_login()")
    void happy_path_testing_login() throws Exception {
        User user = new User(1,"apple","user01","");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(user);
        System.out.println(requestJson);

        String responseString = mockMvc.perform(post("/api/user/login") //调用url
                .contentType(MediaType.APPLICATION_JSON) //json格式
                .content(requestJson).characterEncoding("UTF-8")) //使用前面转换的格式 并设置编码
                .andExpect(status().isOk()) //期待返回的状态码正常
                .andDo(print())
                .andReturn().getResponse().getContentAsString();//打印信息

        verify(userServiceImpl,times(1)).login(any(User.class));
        verify(userServiceImpl,times(1)).getIdByName(anyString());
    }

    @Test
    @DisplayName("happy_path_testing_register()")
    void happy_path_testing_register() throws Exception {
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
    @DisplayName("happy_path_testing_getUserInfo()")
    void happy_path_testing_getUserInfo() throws Exception {
        ResultActions perform=mockMvc.perform(get("/api/info"));
        perform.andExpect(status().isOk());
        verify(userServiceImpl,times(1)).selectByKey(5);
    }

    @Test
    @DisplayName("happy_path_testing_updatePassword()")
    void happy_path_testing_updatePassword() throws Exception {
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
    @DisplayName("happy_path_testing_userInfo()")
    void happy_path_testing_userInfo() throws Exception {
        ResultActions perform=mockMvc.perform(get("/api/userInfo"));
        perform.andExpect(status().isOk());
        verify(userServiceImpl,times(1)).selectAllUser();
    }

    @Test
    @DisplayName("happy_path_testing_updatePasswordByAdmin()")
    void happy_path_testing_updatePasswordByAdmin() throws Exception {
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
