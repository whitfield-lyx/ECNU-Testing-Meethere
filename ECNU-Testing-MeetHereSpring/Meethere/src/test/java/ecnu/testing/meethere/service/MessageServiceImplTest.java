package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.MessageMapper;
import ecnu.testing.meethere.model.Message;
import ecnu.testing.meethere.util.MessageInfo;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MessageServiceImplTest {

    @Mock
    private MessageMapper messageMapper;

    @InjectMocks
    private MessageServiceImpl messageServiceImpl;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void selectByKey() {
        Message message=new Message();
        message.setTime(new Date());
        message.setContent("!");
        message.setUserId(1);
        byte isChecked =1;
        message.setIsChecked(isChecked);
        message.setMessageId(5);
        when(messageMapper.selectByPrimaryKey(5)).thenReturn(message);
        Message selectByKey = messageServiceImpl.selectByKey(5);
        assertEquals(message.getMessageId(), selectByKey.getMessageId());
    }

    @Test
    public void save() {
        Message message=new Message();
        message.setTime(new Date());
        message.setContent("!");
        message.setUserId(1);
        byte isChecked =1;
        message.setIsChecked(isChecked);
        message.setMessageId(5);
        when(messageServiceImpl.save(message)).thenReturn(1);
        Message selectByKey = messageServiceImpl.selectByKey(5);
        assertNull(selectByKey);
    }

    @Test
    public void delete() {
        when(messageServiceImpl.delete(5)).thenReturn(1);
        Message message = messageServiceImpl.selectByKey(5);
        assertNull(message);
    }

    @Test
    public void selectAllMessage() {
        List<MessageInfo> messageInfos = Lists.newArrayList();
        when(messageServiceImpl.selectAllMessage()).thenReturn(messageInfos);
        assertNotNull(messageInfos);
    }

    @Test
    public void checkMessage() {
        int i = 1;
        when(messageServiceImpl.checkMessage(5)).thenReturn(i);
        int checkMessage = messageServiceImpl.checkMessage(5);
        assertEquals(checkMessage, i);
    }

    @Test
   public  void updateMessage() {
        Message message=new Message();
        Byte isChecked = 1;
        message.setIsChecked(isChecked);
        message.setContent("2");
        when(messageMapper.updateByPrimaryKey(message)).thenReturn(1);
        messageServiceImpl.updateMessage(1,1,message);
        assertNotNull(message);
    }
}
