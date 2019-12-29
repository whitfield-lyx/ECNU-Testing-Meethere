package ecnu.testing.meethere.service;


import ecnu.testing.meethere.mapper.AdminMapper;
import ecnu.testing.meethere.mapper.OrderMapper;
import ecnu.testing.meethere.mapper.StadiumMapper;
import ecnu.testing.meethere.model.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    @Mock
    private OrderMapper orderMapper;
    @Mock
    private StadiumMapper stadiumMapper;

    @InjectMocks
    private OrderServiceImpl orderServiceImpl;

    @Before
    public void  setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @org.junit.Test
    public void  selectAllOrder() {
        orderServiceImpl.selectAllOrder();
    }

    @org.junit.Test
    public void  checkOrder() {
        orderServiceImpl.checkOrder(1);
    }

    @org.junit.Test
    public void  selectMyOrder() {
        orderServiceImpl.selectMyOrder(1);
    }

    @org.junit.Test
    public void  addOrder() {
        Order order = new Order();
        order.setHour(1);
        order.setIsChecked((byte) 1);
        order.setOrderId(1);
        order.setStadiumId("1");
        orderServiceImpl.addOrder(order);
    }

    @org.junit.Test
    public void  delete() {
        orderServiceImpl.delete(1);
    }

    @Test
    public void  updateMyOrder() {
        orderServiceImpl.updateMyOrder(1,1,1);
    }
}
