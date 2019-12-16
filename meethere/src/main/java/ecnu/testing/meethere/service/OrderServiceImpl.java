package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.OrderMapper;
import ecnu.testing.meethere.model.Order;
import ecnu.testing.meethere.model.OrderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

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
}
