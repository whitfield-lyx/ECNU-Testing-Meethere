package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.News;
import ecnu.testing.meethere.service.AdminService;
import ecnu.testing.meethere.service.AdminServiceImpl;
import ecnu.testing.meethere.service.NewsServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Date;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@WebMvcTest(NewsController.class)
class NewsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AdminServiceImpl adminServiceImpl;

    @MockBean
    AdminService adminService;

    @MockBean
    NewsServiceImpl newsServiceImpl;

    @Test
    @DisplayName("Testing news()")
    void getNewsList() throws Exception {
        ResultActions perform= mockMvc.perform(get("/api/news"));
        perform.andExpect(status().isOk());
        verify(newsServiceImpl,times(1)).selectAllNews();
    }


    @Test
    @DisplayName("Testing getNewsByID(int key)")
    void getNewsByID() throws Exception {
        ResultActions perform= mockMvc.perform(get("/api/news/1"));
        perform.andExpect(status().isOk());
        verify(newsServiceImpl,times(1)).selectByKey(1);
    }

    @Test
    @DisplayName("Testing addNews(int key)")
    void addNews() throws Exception {
        ResultActions perform= mockMvc.perform(post("/api/news"));
        News news = new News();
        news.setContent("!");
        news.setName("1");
        news.setTime(new Date());
        news.setNewsId(1);
        perform.andExpect(status().isOk());
        verify(newsServiceImpl,times(1)).save(news);
    }

    @Test
    @DisplayName("Testing deleteNewsByID(int key)")
    void deleteNewsByID() throws Exception {
        ResultActions perform= mockMvc.perform(delete("/api//news/1"));
        perform.andExpect(status().isOk());
        verify(newsServiceImpl,times(1)).delete(1);
    }

    @Test
    @DisplayName("Testing updateNews(int key)")
    void updateNews() throws Exception {
        ResultActions perform= mockMvc.perform(get("/api/update/1"));
        News news = new News();
        news.setContent("!");
        news.setName("1");
        news.setTime(new Date());
        news.setNewsId(1);
        perform.andExpect(status().isOk());
        verify(newsServiceImpl,times(1)).updateNews(1,news);
    }
}
