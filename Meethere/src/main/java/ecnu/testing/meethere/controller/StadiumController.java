package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.service.StadiumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class StadiumController {
    @Autowired
    private StadiumServiceImpl stadiumServiceImpl;
}
