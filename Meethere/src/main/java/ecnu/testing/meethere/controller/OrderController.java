package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderServiceImpl;

}
