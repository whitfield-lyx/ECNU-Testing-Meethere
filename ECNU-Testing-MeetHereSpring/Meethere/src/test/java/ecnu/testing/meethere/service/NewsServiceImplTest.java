package ecnu.testing.meethere.service;


import ecnu.testing.meethere.mapper.NewsMapper;
import ecnu.testing.meethere.model.News;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
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
        List<News> news = Lists.newArrayList();
        when(newsServiceImpl.selectAllNews()).thenReturn(news);
        assertNotNull(news);
    }

    @Test
    public void  selectByKey() {
        News news = new News();
        news.setContent("!");
        news.setName("1");
        news.setTime(new Date());
        news.setNewsId(1);
        when(newsServiceImpl.selectByKey(1)).thenReturn(news);
        assertNotNull(news);
    }

    @Test
    public void  save() {
        News news = new News();
        news.setContent("!");
        news.setName("1");
        news.setTime(new Date());
        news.setNewsId(1);
        when(newsServiceImpl.save(news)).thenReturn(1);
        News selectByKey = newsServiceImpl.selectByKey(1);
        assertNull(selectByKey);
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
        when(newsServiceImpl.updateNews(1,news)).thenReturn(null);
        assertNotNull(news);
    }

}
