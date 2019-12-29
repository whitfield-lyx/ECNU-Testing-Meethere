package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.AdminMapper;
import org.junit.Before;
import ecnu.testing.meethere.model.Admin;
import org.junit.jupiter.api.Test;
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
class AdminServiceImplTest {


    @Mock
    private AdminMapper adminMapper;

    @InjectMocks
    private AdminServiceImpl adminServiceImpl;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void selectByKey() {
        Admin admin=new Admin();
        admin.setName("admin10");
        admin.setPassword("111111");
        admin.setAdminId(0);
        when(adminMapper.selectByPrimaryKey(0)).thenReturn(admin);
        Integer result=adminServiceImpl.getIdByName("admin10");
        System.out.println(result);
        assertEquals(result,admin.getAdminId());
    }

    @Test
    void save() {
        Admin admin=new Admin();
        admin.setName("admin10");
        admin.setPassword("111111");
        admin.setAdminId(0);
        adminServiceImpl.save(admin);
    }

    @Test
    void delete() {
        adminServiceImpl.delete(1);
    }

    @Test
    void login() {
        Admin admin=new Admin();
        admin.setName("admin10");
        admin.setPassword("111111");
        admin.setAdminId(0);
        adminServiceImpl.login(admin);
    }
}
