package ecnu.testing.meethere.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void setMessageId() {
        Message message=new Message();
        message.setMessageId(1);
        assertEquals(1,message.getMessageId());
    }

    @Test
    void setUserId() {
        Message message=new Message();
        message.setUserId(1);
        assertEquals(1,message.getUserId());
    }
/*date类型问题*/
    @Test
    void setTime() {
        Message message=new Message();
        Date time =new Date("2019-12-27 13:00:00");
        message.setTime(time);
        assertEquals(time,message.getTime());
    }

    @Test
    void setContent() {
        Message message=new Message();
        message.setContent("2019-12-26");
        assertEquals("2019-12-26",message.getContent());
    }

    @Test
    void setIsChecked() {
        Message message=new Message();
        Byte isChecked=1;
        message.setIsChecked(isChecked);
        assertEquals(isChecked,message.getIsChecked());
    }
}
