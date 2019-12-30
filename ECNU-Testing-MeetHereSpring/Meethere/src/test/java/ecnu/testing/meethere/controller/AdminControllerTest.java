package ecnu.testing.meethere.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import ecnu.testing.meethere.model.Admin;
import ecnu.testing.meethere.service.AdminServiceImpl;
import ecnu.testing.meethere.util.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class AdminControllerTest {

    private MockMvc mockMvc; //mock注入 不用autowired  改用此方式
    private AdminServiceImpl adminServiceImpl;//不用MockBean 改用此方式 注意不要保留冗余的接口

    @BeforeEach
    void  setUp(){
        adminServiceImpl = mock(AdminServiceImpl.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new AdminController(adminServiceImpl)).build();
    }//BeforeEach进行初始化 对接口进行mock 并对mockMVC进行build 要改写Controller的构造函数

    @Test
    @DisplayName("happy_path_testing_login()") //可以按照需求进行更改
    void happy_path_testing_login() throws Exception{ //方法名按照课件的测试方法命名规范修改
        Admin admin=new Admin(1,"111111","admin10");
        //构造要测试的类
        when(adminServiceImpl.login(any(Admin.class))).thenReturn(new Result(200,"AdminLoginTest","AdminLoginTest"));
        //用when打桩 表示 当前者函数调用时 返回一个Result
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(admin);
        //将Object转换为Json格式传入
        System.out.println(requestJson);

        String responseString = mockMvc.perform(post("/api/admin/login") //调用url
                .contentType(MediaType.APPLICATION_JSON) //json格式
                .content(requestJson).characterEncoding("UTF-8")) //使用前面转换的格式 并设置编码
                .andExpect(status().isOk()) //期待返回的状态码正常
                .andDo(print())
                .andReturn().getResponse().getContentAsString();//打印信息
        verify(adminServiceImpl,times(1)).login(any(Admin.class)); //验证Service层是否调用
        verify(adminServiceImpl,times(1)).getIdByName(anyString());//验证Service层是否调用
    }
}
