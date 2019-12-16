package ecnu.testing.meethere.service;

import ecnu.testing.meethere.model.Stadium;
import ecnu.testing.meethere.model.StadiumExample;

import java.util.List;

public interface StadiumService {
    public Stadium selectByKey(Integer key);
    public int save(Stadium entity);
    public int delete(Integer key);
    public int updateAll(Stadium entity);
    public int updateNotNull(Stadium entity);
    public List<Stadium> selectByExample(StadiumExample example);
}
