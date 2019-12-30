package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.StadiumMapper;
import ecnu.testing.meethere.model.Stadium;
import ecnu.testing.meethere.util.Result;
import ecnu.testing.meethere.util.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadiumServiceImpl implements StadiumService {
    @Autowired
    private StadiumMapper stadiumMapper;

    @Override
    public Stadium selectByKey(String key) {
        return stadiumMapper.selectByPrimaryKey(key);
    }

    @Override
    public int save(Stadium entity) {
        return stadiumMapper.insert(entity);
    }

    @Override
    public int delete(String key) {
        return stadiumMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int updateAll(Stadium entity) {
        return stadiumMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateNotNull(Stadium entity) {
        return stadiumMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<Stadium> selectAllStadium() {
        return stadiumMapper.selectAllStadium();
    }

    @Override
    public Result updateStadium(Stadium stadium) {
        System.out.println("stadium id: "+stadium.getStadiumId());
        Stadium oldStadium = stadiumMapper.selectByPrimaryKey(stadium.getStadiumId());
        if(oldStadium==null){
            return ResultFactory.buildFailResult("修改场馆信息失败，不存在该场馆");
        }
        if(stadium.getAddress()!=null){
            oldStadium.setAddress(stadium.getAddress());
        }
        if(stadium.getPrice()!=null){
            oldStadium.setPrice(stadium.getPrice());
        }
        if(stadium.getInformation()!=null){
            oldStadium.setInformation(stadium.getInformation());
        }
        stadiumMapper.updateByPrimaryKey(oldStadium);
        return ResultFactory.buildSuccessResult("修改场馆信息成功");
    }

}

