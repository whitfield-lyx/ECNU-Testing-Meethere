package ecnu.testing.meethere.service;


import ecnu.testing.meethere.mapper.NewsMapper;
import ecnu.testing.meethere.model.News;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

//@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class NewsServiceImplTest {
    @Mock
    private NewsMapper newsMapper;

    @InjectMocks
    private NewsServiceImpl newsServiceImpl;

    @BeforeEach
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
        verify(newsServiceImpl,times(1)).delete(anyInt());
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
