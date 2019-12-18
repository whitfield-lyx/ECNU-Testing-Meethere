package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.*;
import ecnu.testing.meethere.model.*;
import ecnu.testing.meethere.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StadiumMapper stadiumMapper;

    @Override
    public Order selectByKey(Integer key) {
        return orderMapper.selectByPrimaryKey(key);
    }

    @Override
    public int save(Order entity) {
        return orderMapper.insert(entity);
    }

    @Override
    public int delete(Integer key) {
        return orderMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int updateAll(Order entity) {
        return orderMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateNotNull(Order entity) {
        return orderMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<Order> selectByExample(OrderExample example) {
        return orderMapper.selectByExample(example);
    }

    @Override
    public List<OrderInfo> selectAllOrder() {
        List<Order> orderList = orderMapper.selectAllOrder();
        List<OrderInfo> orderInfoList = new ArrayList<OrderInfo>();
        for(Order order : orderList){
            Stadium stadium = stadiumMapper.selectByPrimaryKey(order.getStadiumId());
            OrderInfo orderInfo = new OrderInfo(order,stadium);
            orderInfoList.add(orderInfo);
            orderInfo.display();
        }
        return orderInfoList;
    }

    @Override
    public int checkOrder(Integer orderId) {
        return orderMapper.updateIsChecked(orderId);
    }

    @Override
    public List<OrderInfo> selectMyOrder(Integer userId) {
        List<Order> orderList = orderMapper.selectMyOrder(userId);
        List<OrderInfo> orderInfoList = null;
        for(Order order : orderList){
            Stadium stadium = stadiumMapper.selectByPrimaryKey(order.getStadiumId());
            orderInfoList.add(new OrderInfo(order, stadium));
        }
        return orderInfoList;
    }

    @Override
    public Result addOrder(Order order) {
        Stadium stadium = stadiumMapper.selectByPrimaryKey(order.getStadiumId());
        String bookedTime = stadium.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(int i=0; i<order.getHour(); i++){
            String time = DateUtils.addHours(sdf.format(order.getTime()),i);
            if(bookedTime==null){
                bookedTime="";
                break;
            }
            if(bookedTime.contains(time)){
                return ResultFactory.buildFailResult("该时间已被预约，新增订单失败，请选择其他时间");
            }
        }
        //若无重合的时间，则新增order
        save(order);
        //并在bookedTime中加入新的时间
        for(int i=0; i<order.getHour(); i++){
            String time = DateUtils.addHours(sdf.format(order.getTime()),i);
            bookedTime = bookedTime + "\t" + time;
        }
        stadium.setTime(bookedTime);
        //更新stadium中的time字段
        stadiumMapper.updateByPrimaryKey(stadium);
        return ResultFactory.buildSuccessResult("新增订单成功");
    }
}
