package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.StadiumMapper;
import ecnu.testing.meethere.model.Stadium;
import ecnu.testing.meethere.model.StadiumExample;
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
    public List<Stadium> selectByExample(StadiumExample example) {
        return stadiumMapper.selectByExample(example);
    }

    @Override
    public List<Stadium> selectAllStadium() {
        return stadiumMapper.selectAllStadium();
    }

}
