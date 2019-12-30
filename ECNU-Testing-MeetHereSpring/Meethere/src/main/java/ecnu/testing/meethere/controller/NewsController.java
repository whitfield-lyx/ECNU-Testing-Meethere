package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.News;
import ecnu.testing.meethere.service.AdminServiceImpl;
import ecnu.testing.meethere.service.NewsServiceImpl;
import ecnu.testing.meethere.util.Result;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class NewsController {
    final
    NewsServiceImpl newsServiceImpl;
    final
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

    /**
     * 管理员 修改新闻
     */
    @PutMapping("/news/update/{id}")
    public Result updateNews(@PathVariable("id") Integer newsId, @RequestBody News news){
        /* 仅修改 content 字段*/
        return newsServiceImpl.updateNews(newsId, news);
    }
}
