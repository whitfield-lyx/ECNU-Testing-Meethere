package ecnu.testing.meethere.service;

import ecnu.testing.meethere.model.Order;
import ecnu.testing.meethere.util.OrderInfo;
import ecnu.testing.meethere.util.Result;

import java.util.List;

public interface OrderService{
    public Order selectByKey(Integer key);
    public int save(Order entity);
    public int delete(Integer key);
    public int updateAll(Order entity);
    public int updateNotNull(Order entity);

    public List<OrderInfo> selectAllOrder();
    public int checkOrder(Integer orderId);
    public List<OrderInfo> selectMyOrder(Integer userId);
    public Result addOrder(Order order);
    public Result updateMyOrder(Integer userId, Integer orderId, Integer hour);
}
