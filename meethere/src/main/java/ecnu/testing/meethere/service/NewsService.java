package ecnu.testing.meethere.service;

import ecnu.testing.meethere.model.News;
import ecnu.testing.meethere.model.NewsExample;

import java.util.List;

public interface NewsService{
    public News selectByKey(Integer key);
    public int save(News entity);
    public int delete(Integer key);
    public int updateAll(News entity);
    public int updateNotNull(News entity);
    public List<News> selectByExample(NewsExample example);
}
