package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.NewsMapper;
import ecnu.testing.meethere.model.News;
import ecnu.testing.meethere.model.NewsExample;
import ecnu.testing.meethere.util.Result;
import ecnu.testing.meethere.util.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public News selectByKey(Integer key) {
        return newsMapper.selectByPrimaryKey(key);
    }

    @Override
    public int save(News entity) {
        entity.setTime(new Date());
        return newsMapper.insert(entity);
    }

    @Override
    public int delete(Integer key) {
        return newsMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int updateAll(News entity) {
        return newsMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateNotNull(News entity) {
        return newsMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<News> selectByExample(NewsExample example) {
        return newsMapper.selectByExample(example);
    }

    @Override
    public List<News> selectAllNews(){
        return newsMapper.selectAllNews();
    }

    @Override
    public Result updateNews(Integer newsId, String content) {
        News news = newsMapper.selectByPrimaryKey(newsId);
        if(news==null){
            return ResultFactory.buildFailResult("不存在新闻，修改失败");
        }
        news.setContent(content);
        news.setTime(new Date());
        newsMapper.updateByPrimaryKey(news);
        return ResultFactory.buildSuccessResult("修改新闻成功");
    }
}
