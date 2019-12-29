package ecnu.testing.meethere.service;


import ecnu.testing.meethere.mapper.AdminMapper;
import ecnu.testing.meethere.mapper.StadiumMapper;
import ecnu.testing.meethere.model.Stadium;
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

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class StadiumServiceImplTest {
    @Mock
    private StadiumMapper stadiumMapper;
    @InjectMocks
    private StadiumServiceImpl stadiumServiceImpl;

    @Before
    public void  setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @org.junit.Test
    public void  selectAllStadium() {
        stadiumServiceImpl.selectAllStadium();
    }

    @Test
    public void  updateStadium() {
        Stadium stadium = new Stadium();
        stadium.setAddress("1");
        stadium.setInformation("1");
        stadium.setPrice(1);
        stadium.setTime("1");
        stadium.setStadiumId("1");
        stadiumServiceImpl.updateStadium(stadium);
    }
}
