package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.Stadium;
import ecnu.testing.meethere.service.StadiumServiceImpl;
import ecnu.testing.meethere.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StadiumController {
    private final StadiumServiceImpl stadiumServiceImpl;

    public StadiumController(StadiumServiceImpl stadiumServiceImpl) {
        this.stadiumServiceImpl = stadiumServiceImpl;
    }

    /**
     * 预约界面 显示所有场馆
     */
    @GetMapping("/stadium")
    public List<Stadium> getAllStadium()
    {
        return stadiumServiceImpl.selectAllStadium();
    }

    /**
     * 管理员 修改场馆信息
     * 只能修改 address price info 信息
     */
    @RequestMapping("/stadium/update")
    public Result updateStadium(@RequestBody Stadium stadium){
        return stadiumServiceImpl.updateStadium(stadium);
    }
}
