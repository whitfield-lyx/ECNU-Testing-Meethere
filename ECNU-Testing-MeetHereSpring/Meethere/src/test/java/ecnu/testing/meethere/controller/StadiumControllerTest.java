package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.Stadium;
import ecnu.testing.meethere.service.StadiumServiceImpl;
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

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@WebMvcTest(StadiumController.class)
class StadiumControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StadiumServiceImpl stadiumServiceImpl;

    @Test
    @DisplayName("Testing getAllStadium()")
    void getAllStadium() throws Exception {
        ResultActions perform=mockMvc.perform(get("/api/stadium"));
        perform.andExpect(status().isOk());
        verify(stadiumServiceImpl,times(1)).selectAllStadium();
    }

    @Test
    @DisplayName("Testing updateStadium()")
    void updateStadium() throws Exception {
        ResultActions perform=mockMvc.perform(get("/api/stadium/update"));
        Stadium stadium = new Stadium();
        stadium.setAddress("1");
        stadium.setInformation("1");
        stadium.setPrice(1);
        stadium.setTime("1");
        stadium.setStadiumId("1");
        perform.andExpect(status().isOk());
        verify(stadiumServiceImpl,times(1)).updateStadium(stadium);
    }
}
