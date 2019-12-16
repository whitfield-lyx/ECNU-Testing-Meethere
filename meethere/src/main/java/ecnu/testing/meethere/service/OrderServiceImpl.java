package ecnu.testing.meethere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends BaseService<OrderService> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
}
