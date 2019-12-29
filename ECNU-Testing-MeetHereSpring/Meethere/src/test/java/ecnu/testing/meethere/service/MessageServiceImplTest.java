package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.MessageMapper;
import ecnu.testing.meethere.model.Message;
import ecnu.testing.meethere.util.MessageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceImplTest {

    @Mock
    private MessageMapper messageMapper;

    @InjectMocks
    private MessageServiceImpl messageServiceImpl;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void selectByKey() {
        Message message = messageServiceImpl.selectByKey(1);
        System.out.println(message);
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
        messageServiceImpl.save(message);
        System.out.println("保存成功：" + message);
    }

    @Test
    public void delete() {
        messageServiceImpl.delete(5);
        System.out.println("删除成功");
    }

    @Test
    public void updateAll() {
    }

    @Test
    public void updateNotNull() {
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectAllMessage() {
        List<MessageInfo> messageInfos = messageServiceImpl.selectAllMessage();
        System.out.println("查询出结果数为：" + messageInfos == null?0:messageInfos.size());
    }

    @Test
    public void checkMessage() {
        int i = messageServiceImpl.checkMessage(5);
        System.out.println(i);
    }

    @Test
    public void updateMessage() {
        Message message=new Message();
        Byte isCheched = 1;
        message.setIsChecked(isCheched);
        message.setContent("2");
        messageServiceImpl.updateMessage(1,1,message);
        System.out.println("更新成功");
    }
}
