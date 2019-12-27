package ecnu.testing.meethere.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StadiumTest {

    @Test
    void setStadiumId() {
        Stadium stadium=new Stadium();
        stadium.setStadiumId("1");
        assertEquals("1",stadium.getStadiumId());
    }

    @Test
    void setTime() {
    }

    @Test
    void setPrice() {
        Stadium stadium=new Stadium();
        stadium.setPrice(100);
        assertEquals(100,stadium.getPrice());
    }

    @Test
    void setAddress() {
        Stadium stadium=new Stadium();
        stadium.setAddress("xxxx/xxxx/xxxx");
        assertEquals("xxxx/xxxx/xxxx",stadium.getAddress());
    }

    @Test
    void setInformation() {
        Stadium stadium=new Stadium();
        stadium.setInformation("这是一个场地");
        assertEquals("这是一个场地",stadium.getInformation());
    }
}
