package ecnu.testing.meethere.service;


import ecnu.testing.meethere.mapper.NewsMapper;
import ecnu.testing.meethere.model.News;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsServiceImplTest {
    @Mock
    private NewsMapper newsMapper;

    @InjectMocks
    private NewsServiceImpl newsServiceImpl;

    @Before
    public void  setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void  selectAllNews() {
        newsServiceImpl.selectAllNews();
    }

    @Test
    public void  selectByKey() {
        newsServiceImpl.selectByKey(1);
    }

    @Test
    public void  save() {
        News news = new News();
        news.setContent("!");
        news.setName("1");
        news.setTime(new Date());
        news.setNewsId(1);
        newsServiceImpl.save(news);
    }

    @Test
    public void  delete() {
        newsServiceImpl.delete(1);
    }

    @Test
    public void  updateNews() {
        News news = new News();
        news.setContent("!");
        news.setName("1");
        news.setTime(new Date());
        news.setNewsId(1);
        newsServiceImpl.updateNews(1,news);
    }

}
