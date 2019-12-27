package ecnu.testing.meethere.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void setUserId() {
        User user=new User();
        user.setUserId(1);
        assertEquals(1,user.getUserId());
    }

    @Test
    void setPassword() {
        User user=new User();
        user.setPassword("111111");
        assertEquals("111111",user.getPassword());
    }

    @Test
    void setName() {
        User user=new User();
        user.setName("flora");
        assertEquals("flora",user.getName());
    }

    @Test
    void setNickname() {
        User user=new User();
        user.setNickname("flora1");
        assertEquals("flora1",user.getNickname());
    }
}
