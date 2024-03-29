package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.News;
import ecnu.testing.meethere.service.AdminServiceImpl;
import ecnu.testing.meethere.service.NewsServiceImpl;
import ecnu.testing.meethere.util.Result;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class NewsController {
    private final
    NewsServiceImpl newsServiceImpl;
    private final
    AdminServiceImpl adminServiceImpl;

    public NewsController(NewsServiceImpl newsServiceImpl, AdminServiceImpl adminServiceImpl) {
        this.newsServiceImpl = newsServiceImpl;
        this.adminServiceImpl = adminServiceImpl;
    }

    /**
     * 获取所有新闻
     */
    @GetMapping("/news")
    @ResponseStatus(HttpStatus.OK)
    public List<News> getNewsList()
    {
        return newsServiceImpl.selectAllNews();
    }

    /**
     * 获取指定新闻 仅测试用
     */
    @GetMapping("/news/{id}")
    @ResponseStatus(HttpStatus.OK)
    public News getNewsByID(@PathVariable("id") Integer id)
    {
        return newsServiceImpl.selectByKey(id);
    }

    /**
     * 管理员 发布新闻
     */
    @PostMapping("/news")
    @ResponseStatus(HttpStatus.CREATED)
    public int addNews(@SessionAttribute Integer adminId, @RequestBody News news)
    {
        /* 根据session中adminId设定news的admin name */
        news.setName(adminServiceImpl.selectByKey(adminId).getName());

        Logger logger = (Logger) LoggerFactory.getLogger(getClass());
        logger.info("Title of news is "+news.getTitle());
        logger.info("Content of news is "+news.getContent());
        logger.info("Time of news is "+news.getTime());
        logger.info("Admin name of news is "+news.getName());

        return newsServiceImpl.save(news);
    }

    /**
     * 管理员 删除指定新闻
     */
    @DeleteMapping("/news/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public int deleteNewsByID(@PathVariable("id") Integer id){
        return newsServiceImpl.delete(id);
    }

    /**
     * 管理员 修改新闻
     */
    @PutMapping("/news/update/{id}")
    public Result updateNews(@PathVariable("id") Integer newsId, @RequestBody News news){
        /* 仅修改 content 字段*/
        return newsServiceImpl.updateNews(newsId, news);
    }
}
