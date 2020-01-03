package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.Order;
import ecnu.testing.meethere.service.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OrderControllerTest {
    private MockMvc mockMvc;

    private OrderServiceImpl orderServiceImpl;
    private MockHttpSession session;

    @BeforeEach
    void  setUp(){
        orderServiceImpl = mock(OrderServiceImpl.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new OrderController(orderServiceImpl)).build();
        session = new MockHttpSession();
    }

    @Test
    @DisplayName("happy_path_testing_getAllOrderList()")
    void happy_path_testing_getAllOrderList() throws Exception {
        ResultActions perform=mockMvc.perform(get("/api/order/all"));
        perform.andExpect(status().isOk());
        verify(orderServiceImpl,times(1)).selectAllOrder();
    }

    @Test
    @DisplayName("happy_path_testing_checkOrder()")
    void happy_path_testing_checkOrder() throws Exception {
        ResultActions perform=mockMvc.perform(put("/api/order/check/1"));
        perform.andExpect(status().isOk());
        verify(orderServiceImpl,times(1)).checkOrder(1);
    }

    @Test
    @DisplayName("happy_path_testing_getMyOrderList()")
    void happy_path_testing_getMyOrderList() throws Exception {
        ResultActions perform=mockMvc.perform(get("/api/order/myOrder"));
        perform.andExpect(status().isOk());
        verify(orderServiceImpl,times(1)).selectMyOrder(1);
    }

    @Test
    @DisplayName("happy_path_testing_addOrder()")
    void happy_path_testing_addOrder() throws Exception {
        ResultActions perform=mockMvc.perform(post("/api/order/newOrder"));
        Order order = new Order();
        order.setHour(1);
        order.setIsChecked((byte) 1);
        order.setOrderId(1);
        order.setStadiumId("1");
        perform.andExpect(status().isOk());
        verify(orderServiceImpl,times(1)).addOrder(order);
    }

    @Test
    @DisplayName("happy_path_testing_deleteOrderByID()")
    void happy_path_testing_deleteOrderByID() throws Exception {
        ResultActions perform=mockMvc.perform(delete("/api/order/1"));
        perform.andExpect(status().isOk());
        verify(orderServiceImpl,times(1)).delete(1);
    }

    @Test
    @DisplayName("happy_path_testing_updateMyOrder()")
    void happy_path_testing_updateMyOrder() throws Exception {
        ResultActions perform=mockMvc.perform(put("/api/myOrder/1"));
        perform.andExpect(status().isOk());
        verify(orderServiceImpl,times(1)).updateMyOrder(1, 1, 1);
    }
}
