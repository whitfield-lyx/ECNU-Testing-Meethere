package ecnu.testing.meethere.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    @Test
    void setOrderId() {
        Order order=new Order();
        order.setOrderId(1);
        assertEquals(1,order.getOrderId());
    }

    @Test
    void setUserId() {
        Order order=new Order();
        order.setUserId(1);
        assertEquals(1,order.getUserId());
    }

    @Test
    void setStadiumId() {
        Order order=new Order();
        order.setStadiumId("111");
        assertEquals("111",order.getStadiumId());
    }

    @Test
    void setTime() {
        Order order=new Order();
        //order.setTime(2019-12-27 10:00:00);
        //assertEquals("2019-12-27 10:00:00",order.getTime());
    }

    @Test
    void setHour() {
        Order order=new Order();
        order.setHour(2);
        assertEquals(2,order.getHour());
    }

    @Test
    void setIsChecked() {
         Order order=new Order();
         //order.setIsChecked();
         //assertEquals(0,order.getIsChecked());
    }
}
