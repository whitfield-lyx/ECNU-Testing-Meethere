package ecnu.testing.meethere.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import ecnu.testing.meethere.model.Stadium;
import ecnu.testing.meethere.service.StadiumServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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

class StadiumControllerTest {
    private MockMvc mockMvc;

    private StadiumServiceImpl stadiumServiceImpl;

    @BeforeEach
    void  setUp(){
        stadiumServiceImpl = mock(StadiumServiceImpl.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new StadiumController(stadiumServiceImpl)).build();
    }

    @Test
    @DisplayName("happy_path_testing_getAllStadium()")
    void happy_path_testing_getAllStadium() throws Exception {
        ResultActions perform=mockMvc.perform(get("/api/stadium"));
        perform.andExpect(status().isOk());
        verify(stadiumServiceImpl,times(1)).selectAllStadium();
    }

    @Test
    @DisplayName("happy_path_testing_updateStadium()")
    void happy_path_testing_updateStadium() throws Exception {
        Stadium stadium = new Stadium("东操场", " 2019-12-30 08:00:002019-12-30 09:00:002019-12-30 10:00:00", 1000, "上海市中山北路3664号", "东操场是位于校园东部的一个大操场。");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(stadium);
        System.out.println(requestJson);

        String responseString = mockMvc.perform(post("/api/stadium/update") //调用url
                .contentType(MediaType.APPLICATION_JSON) //json格式
                .content(requestJson).characterEncoding("UTF-8")) //使用前面转换的格式 并设置编码
                .andExpect(status().isOk()) //期待返回的状态码正常
                .andDo(print())
                .andReturn().getResponse().getContentAsString();//打印信息
        verify(stadiumServiceImpl,times(1)).updateStadium(any(Stadium.class));
    }
}
