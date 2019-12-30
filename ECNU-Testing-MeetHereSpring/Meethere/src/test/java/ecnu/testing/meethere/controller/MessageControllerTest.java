package ecnu.testing.meethere.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ecnu.testing.meethere.model.Admin;
import ecnu.testing.meethere.model.Message;
import ecnu.testing.meethere.service.MessageService;
import ecnu.testing.meethere.service.MessageServiceImpl;
import ecnu.testing.meethere.util.Result;
import org.junit.jupiter.api.BeforeAll;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
//@WebMvcTest(MessageController.class)
//@ContextConfiguration(locations = {"classpath:application.properties", "classpath:generatorConfig.xml"})
class MessageControllerTest {


    private MockMvc mockMvc;

    private MessageService messageService;

    private MessageServiceImpl messageServiceImpl;

    private MockHttpSession session;

    @BeforeEach
    void setUp(){
        messageService = mock(MessageService.class);
        messageServiceImpl = mock(MessageServiceImpl.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new MessageController(messageServiceImpl)).build();
        session = new MockHttpSession();
    }

    @Test
    @DisplayName("happy_path_testing_addMessage()")
    void happy_path_testing_addMessage() throws Exception {

        Message message=new Message(1, 0, new Date(), "test message", (byte)1);
        Integer userId = 1;
        message.setUserId(userId);

        when(messageServiceImpl.save(any(Message.class))).thenReturn(1);

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(message);

        ResultActions perform=mockMvc.perform(post("/api/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson).characterEncoding("UTF-8"))
                .andExpect(status().isCreated());
        verify(message,times(1)).setUserId(userId);
        verify(messageServiceImpl,times(1)).save(any(Message.class));
    }

    @Test
    @DisplayName("happy_path_testing_deleteMessageByID(int key)")
    void happy_path_testing_deleteMessageByID() throws Exception{
        when(messageServiceImpl.delete(anyInt())).thenReturn(1);
        ResultActions perform =mockMvc.perform(delete("/api/message/1"))
        .andExpect(status().isNoContent());
        verify(messageServiceImpl,times(1)).delete(anyInt());
    }

    @Test
    @DisplayName("happy_path_testing_checkMessage()")
    void happy_path_testing_checkMessage() throws Exception{
        when(messageServiceImpl.checkMessage(anyInt())).thenReturn(1);
        ResultActions perform=mockMvc.perform(put("/api/message/check/5"));
        perform.andExpect(status().isOk());
        verify(messageServiceImpl,times(1)).checkMessage(anyInt());
    }

    @Test
    @DisplayName("happy_path_testing_updateMessage()")
    void happy_path_testing_updateMessage() throws Exception{
        when(messageServiceImpl.updateMessage(anyInt(),anyInt(),any(Message.class))).thenReturn(new Result(200,"test","test"));
        ResultActions perform=mockMvc.perform(get("/api/message/update/5"));
        perform.andExpect(status().isOk());
        Message message=new Message();
        Byte isChecked = 1;
        message.setIsChecked(isChecked);
        message.setContent("2");
        verify(messageServiceImpl,times(1)).updateMessage(anyInt(),anyInt(),any(Message.class));
    }

    @Test
    @DisplayName("happy_path_testing_getMessageList()")
    void happy_path_testing_getMassageList() throws Exception{
        ResultActions perform= mockMvc.perform(get("/api/message"));
        perform.andExpect(status().isOk());
        verify(messageServiceImpl,times(1)).selectAllMessage();
    }

    @Test
    @DisplayName("happy_path_testing_getMessageByID()")
    void happy_path_testing_getMessageByID() throws Exception{
        ResultActions perform=mockMvc.perform(get("/api/message/1"));
        perform.andExpect(status().isOk());
        verify(messageServiceImpl,times(1)).selectByKey(1);
    }
}
