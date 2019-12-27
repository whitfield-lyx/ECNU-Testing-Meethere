package ecnu.testing.meethere.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @Test
    void setAdminId() {
        Admin admin=new Admin();
        admin.setAdminId(1);
        assertEquals(1,admin.getAdminId());
    }

    @Test
    void setPassword() {
        Admin admin=new Admin();
        admin.setPassword("123456");
        assertEquals("123456",admin.getPassword());
    }

    @Test
    void setName() {
        Admin admin=new Admin();
        admin.setName("flora");
        assertEquals("flora",admin.getName());
    }
}
