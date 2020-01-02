package ecnu.testing.meethere.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ecnu.testing.meethere.model.News;
import ecnu.testing.meethere.service.AdminServiceImpl;
import ecnu.testing.meethere.service.NewsServiceImpl;
import ecnu.testing.meethere.util.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
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

    private NewsServiceImpl newsServiceImpl;
    private MockHttpSession session;

    @BeforeEach
    void  setUp(){
        adminServiceImpl = mock(AdminServiceImpl.class);
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
        News news = new News(1,"title","new news",new Date(),"news name");
        Integer newsId = 1;
        news.setNewsId(newsId);
        when(newsServiceImpl.save(any(News.class))).thenReturn(0);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(news);
        ResultActions perform=mockMvc.perform(post("/api/news")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson).characterEncoding("UTF-8"))
                .andExpect(status().isCreated());
        verify(news,times(1)).setNewsId(newsId);
        verify(newsServiceImpl,times(1)).save(any(News.class));
    }

    @Test
    @DisplayName("happy_path_testing_deleteNewsByID(int key)")
    void happy_path_testing_deleteNewsByID() throws Exception {
        when(newsServiceImpl.delete(anyInt())).thenReturn(1);
        ResultActions perform= mockMvc.perform(delete("/api/news/1"));
        perform.andExpect(status().isNoContent());
        verify(newsServiceImpl,times(1)).delete(1);
    }

    @Test
    void news_doesnt_exist_when_delete_a_news() throws Exception{
        when(newsServiceImpl.selectByKey(2)).thenReturn(null);
        when(newsServiceImpl.delete(2)).thenReturn(0);
       // mockMvc.perform(delete("/api/news/2"))
                //.andExpect(status().isOk())
               // .andExpect(status().isBadRequest());
        verify(newsServiceImpl,times(1)).delete(1);
    }

    @Test
    @DisplayName("happy_path_testing_updateNews(int key)")
    void happy_path_testing_updateNews() throws Exception {
        News news = new News();
        news.setContent("happy_path_testing_updateNews");
        news.setName("1");
        news.setTime(new Date());
        news.setNewsId(1);
        when(newsServiceImpl.updateNews(anyInt(),any(News.class))).thenReturn(new Result(200,"test","test"));
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(news);
        mockMvc.perform(put("/api/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(requestJson))
                .andExpect(status().isOk());
        verify(newsServiceImpl,times(1)).updateNews(1,news);
    }
}
