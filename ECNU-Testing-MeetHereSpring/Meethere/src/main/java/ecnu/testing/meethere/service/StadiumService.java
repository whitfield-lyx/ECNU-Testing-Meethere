package ecnu.testing.meethere.service;

import ecnu.testing.meethere.model.Stadium;
import ecnu.testing.meethere.util.Result;

import java.util.List;

public interface StadiumService {
    public Stadium selectByKey(String key);
    public int save(Stadium entity);
    public int delete(String key);
    public int updateAll(Stadium entity);
    public int updateNotNull(Stadium entity);

    public List<Stadium> selectAllStadium();
    public Result updateStadium(Stadium stadium);
}
