package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.News;
import ecnu.testing.meethere.service.AdminService;
import ecnu.testing.meethere.service.AdminServiceImpl;
import ecnu.testing.meethere.service.NewsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
//@WebMvcTest(NewsController.class)
class NewsControllerTest {

    private MockMvc mockMvc;

    private AdminServiceImpl adminServiceImpl;

   //private AdminService adminService;

    private NewsServiceImpl newsServiceImpl;
    private MockHttpSession session;

    @BeforeEach
    void  setUp(){
        adminServiceImpl = mock(AdminServiceImpl.class);
        //adminService = mock(AdminService.class);
        newsServiceImpl = mock(NewsServiceImpl.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new NewsController(newsServiceImpl, adminServiceImpl)).build();
        session = new MockHttpSession();
    }


    @Test
    @DisplayName("happy_path_testing_getNewsList()")
    void happy_path_testing_getNewsList() throws Exception {
        ResultActions perform= mockMvc.perform(get("/api/news"));
        perform.andExpect(status().isOk());
        verify(newsServiceImpl,times(1)).selectAllNews();
    }


    @Test
    @DisplayName("happy_path_testing_getNewsByID(int key)")
    void happy_path_testing_getNewsByID() throws Exception {
        ResultActions perform= mockMvc.perform(get("/api/news/1"));
        perform.andExpect(status().isOk());
        verify(newsServiceImpl,times(1)).selectByKey(1);
    }

    @Test
    @DisplayName("happy_path_testing_addNews(int key)")
    void happy_path_testing_addNews() throws Exception {
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
    @DisplayName("happy_path_testing_deleteNewsByID(int key)")
    void happy_path_testing_deleteNewsByID() throws Exception {
        ResultActions perform= mockMvc.perform(delete("/api/news/1"));
        perform.andExpect(status().isNoContent());
        verify(newsServiceImpl,times(1)).delete(1);
    }

    @Test
    @DisplayName("happy_path_testing_updateNews(int key)")
    void happy_path_testing_updateNews() throws Exception {
        ResultActions perform= mockMvc.perform(put("/api/update/1"));
        News news = new News();
        news.setContent("happy_path_testing_updateNews");
        news.setName("1");
        news.setTime(new Date());
        news.setNewsId(1);
        perform.andExpect(status().isOk());
        verify(newsServiceImpl,times(1)).updateNews(1,news);
    }
}
