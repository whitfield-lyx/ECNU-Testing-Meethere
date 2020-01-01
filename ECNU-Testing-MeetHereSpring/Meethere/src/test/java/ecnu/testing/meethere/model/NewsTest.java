package ecnu.testing.meethere.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {

    @Test
    void setNewsId() {
        News news=new News();
        news.setNewsId(1);
        assertEquals(1,news.getNewsId());
    }

    @Test
    void setTitle() {
        News news =new News();
        news.setTitle("1111111");
        assertEquals("1111111",news.getTitle());
    }

    @Test
    void setContent() {
        News news=new News();
        news.setContent("12121212");
        assertEquals("12121212",news.getContent());
    }

    @Test
    void setName() {
        News news=new News();
        news.setName("flora");
        assertEquals("flora",news.getName());
    }
}
