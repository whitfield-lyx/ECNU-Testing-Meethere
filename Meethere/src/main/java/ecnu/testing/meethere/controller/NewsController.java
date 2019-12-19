package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.News;
import ecnu.testing.meethere.service.AdminServiceImpl;
import ecnu.testing.meethere.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NewsController {
    @Autowired
    NewsServiceImpl newsServiceImpl;
    @Autowired
    AdminServiceImpl adminServiceImpl;

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
        System.out.println("Title of news is "+news.getTitle());
        System.out.println("Content of news is "+news.getContent());
        System.out.println("Time of news is "+news.getTime());
        System.out.println("Admin name of news is "+news.getName());
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
}
