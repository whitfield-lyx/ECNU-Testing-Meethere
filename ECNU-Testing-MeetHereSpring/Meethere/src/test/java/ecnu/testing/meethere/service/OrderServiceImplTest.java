package ecnu.testing.meethere.service;


import ecnu.testing.meethere.mapper.OrderMapper;
import ecnu.testing.meethere.mapper.StadiumMapper;
import ecnu.testing.meethere.model.Order;
import ecnu.testing.meethere.util.OrderInfo;
import ecnu.testing.meethere.util.Result;
import org.assertj.core.util.Lists;
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

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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

    @Test
    public void  selectAllOrder() {
        List orderLists = Lists.newArrayList();
        when(orderServiceImpl.selectAllOrder()).thenReturn(orderLists);
        assertNotNull(orderLists);
    }

    @Test
    public void  checkOrder() {
        int i = 1;
        when(orderServiceImpl.checkOrder(1)).thenReturn(i);
        assertNotNull(i);
    }

    @Test
    public void  selectMyOrder() {
        List<OrderInfo> orderInfos = Lists.newArrayList();
        when(orderServiceImpl.selectMyOrder(1)).thenReturn(orderInfos);
        assertNotNull(orderInfos);
    }

    @Test
    public void  addOrder() {
        Order order = new Order();
        order.setHour(1);
        order.setIsChecked((byte) 1);
        order.setOrderId(1);
        order.setStadiumId("1");
        orderServiceImpl.addOrder(order);
        when(orderServiceImpl.addOrder(order)).thenReturn(null);
        assertNotNull(order);
    }

    @Test
    public void  delete() {

        int i = -1;
        when(orderMapper.deleteByPrimaryKey(1)).thenReturn(1);
        int delete = orderServiceImpl.delete(1);
        assertEquals(delete, i);
    }

    @Test
    public void  updateMyOrder() {
        Order order = orderServiceImpl.selectByKey(1);
        when(orderServiceImpl.selectByKey(1)).thenReturn(order);
        Result result = orderServiceImpl.updateMyOrder(1, 1, 1);
        assertNotNull(result);
    }
}
