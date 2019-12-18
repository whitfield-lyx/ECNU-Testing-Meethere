package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.Order;
import ecnu.testing.meethere.service.OrderServiceImpl;
import ecnu.testing.meethere.util.OrderInfo;
import ecnu.testing.meethere.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    /**
     * 对管理员 显示所有订单
     */
    @GetMapping("/all")
    public List<OrderInfo> getAllOrderList()
    {
        return orderServiceImpl.selectAllOrder();
    }

    /**
     * 对管理员 审核通过某个订单
     */
    @PostMapping("/check/{id}")
    public int checkOrder(@PathVariable("id") Integer orderId)
    {
        return orderServiceImpl.checkOrder(orderId);
    }

    /**
     * 对用户 显示该用户的所有订单
     */
    @GetMapping("/myOrder")
    //@SessionAttribute()
    public List<OrderInfo> getMyOrderList(Integer userId)
    {
        return orderServiceImpl.selectMyOrder(userId);
    }

    /**
     * 对用户 新增一个订单
     */
    @RequestMapping("/newOrder")
    public Result addOrder(@RequestBody Order order){
        return orderServiceImpl.addOrder(order);
    }

    /**
     * 用户和管理员都可 取消某个订单
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public int deleteOrderByID(@PathVariable("id") Integer orderId){
        return orderServiceImpl.delete(orderId);
    }

}
