package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.Order;
import ecnu.testing.meethere.service.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    OrderServiceImpl orderServiceImpl;

    @Test
    @DisplayName("Testing getAllOrderList()")
    void getAllOrderList() throws Exception {
        ResultActions perform=mockMvc.perform(get("/api/order/all"));
        perform.andExpect(status().isOk());
        verify(orderServiceImpl,times(1)).selectAllOrder();
    }

    @Test
    @DisplayName("Testing checkOrder()")
    void checkOrder() throws Exception {
        ResultActions perform=mockMvc.perform(put("/api/order/check/1"));
        perform.andExpect(status().isOk());
        verify(orderServiceImpl,times(1)).checkOrder(1);
    }

    @Test
    @DisplayName("Testing getMyOrderList()")
    void getMyOrderList() throws Exception {
        ResultActions perform=mockMvc.perform(get("/api/order/myOrder"));
        perform.andExpect(status().isOk());
        verify(orderServiceImpl,times(1)).selectMyOrder(1);
    }

    @Test
    @DisplayName("Testing addOrder()")
    void addOrder() throws Exception {
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
    @DisplayName("Testing deleteOrderByID()")
    void deleteOrderByID() throws Exception {
        ResultActions perform=mockMvc.perform(delete("/api/order/1"));
        perform.andExpect(status().isOk());
        verify(orderServiceImpl,times(1)).delete(1);
    }

    @Test
    @DisplayName("Testing updateMyOrder()")
    void updateMyOrder() throws Exception {
        ResultActions perform=mockMvc.perform(get("/api/myOrder/1"));
        perform.andExpect(status().isOk());
        verify(orderServiceImpl,times(1)).updateMyOrder(1, 1, 1);
    }
}
