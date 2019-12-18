package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.News;
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

    @GetMapping("/news")
    @ResponseStatus(HttpStatus.OK)
    public List<News> getNewsList()
    {
        return newsServiceImpl.selectAllNews();
    }

    @GetMapping("/news/{id}")
    @ResponseStatus(HttpStatus.OK)
    public News getNewsByID(@PathVariable("id") Integer id)
    {
        return newsServiceImpl.selectByKey(id);
    }

    @PostMapping("/news")
    @ResponseStatus(HttpStatus.CREATED)
    public int addNews(@RequestBody News news)
    {
        System.out.println("Title of news is "+news.getTitle());
        System.out.println("Content of news is "+news.getContent());
        System.out.println("Time of news is "+news.getTime());
        System.out.println("Admin name of news is "+news.getName());
        return newsServiceImpl.save(news);
    }

    @DeleteMapping("/news/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public int deleteNewsByID(@PathVariable("id") Integer id){
        return  newsServiceImpl.delete(id);
    }
}
