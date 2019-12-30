package ecnu.testing.meethere.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ecnu.testing.meethere.model.Message;
import ecnu.testing.meethere.service.MessageService;
import ecnu.testing.meethere.service.MessageServiceImpl;
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

    @BeforeEach
    void setUp(){
        messageService = mock(MessageService.class);
        messageServiceImpl = mock(MessageServiceImpl.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new MessageController(messageServiceImpl)).build();
    }

    @Test
    @DisplayName("Testing addMessage()")
    void addMessage() throws Exception {
        Message message=new Message();
        message.setTime(new Date());
        message.setContent("test message");
        message.setUserId(1);
        byte isChecked =1;
        message.setIsChecked(isChecked);
        message.setMessageId(1);

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(message);

        ResultActions perform=mockMvc.perform(post("/api/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isCreated());
        verify(messageServiceImpl,times(1)).save(message);
    }

    @Test
    @DisplayName("Testing deleteMessageByID(int key)")
    void deleteMessageByID() throws Exception{
        ResultActions perform =mockMvc.perform(delete("/api/message/3"));
        perform.andExpect(status().isNoContent());
        verify(messageServiceImpl,times(1)).delete(3);

    }

    @Test
    @DisplayName("Testing checkMessage()")
    void checkMessage() throws Exception{
        ResultActions perform=mockMvc.perform(get("/api/message/check/5"));
        perform.andExpect(status().isOk());
        verify(messageServiceImpl,times(1)).checkMessage(5);
    }

    @Test
    @DisplayName("Testing updateMessage()")
    void updateMessage() throws Exception{
        ResultActions perform=mockMvc.perform(get("/api/message/update/5"));
        perform.andExpect(status().isOk());
        Message message=new Message();
        Byte isCheched = 1;
        message.setIsChecked(isCheched);
        message.setContent("2");
        verify(messageServiceImpl,times(1)).updateMessage(1,2,message);
    }

    @Test
    @DisplayName("Testing getMessageList()")
    void getMassageList() throws Exception{
        ResultActions perform= mockMvc.perform(get("/api/message"));
        perform.andExpect(status().isOk());
        verify(messageServiceImpl,times(1)).selectAllMessage();
    }

    @Test
    @DisplayName("Testing getMessageByID()")
    void getMessageByID() throws Exception{
        ResultActions perform=mockMvc.perform(get("/api/message/1"));
        perform.andExpect(status().isOk());
        verify(messageServiceImpl,times(1)).selectByKey(1);
    }
}
