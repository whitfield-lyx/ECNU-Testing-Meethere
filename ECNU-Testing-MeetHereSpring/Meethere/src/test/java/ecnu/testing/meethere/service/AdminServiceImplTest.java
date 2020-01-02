package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.AdminMapper;
import ecnu.testing.meethere.model.Admin;
import ecnu.testing.meethere.util.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

//@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest
class AdminServiceImplTest {


    @Mock
    private AdminMapper adminMapper;

    @InjectMocks
    private AdminServiceImpl adminServiceImpl;

    @BeforeEach
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
        //System.out.println(result);
        assertEquals(result,admin.getAdminId());
    }

    @Test
    void save() {
        Admin admin=new Admin();
        admin.setName("admin10");
        admin.setPassword("111111");
        admin.setAdminId(0);
        int id =adminServiceImpl.save(admin);
        when(adminServiceImpl.save(any(Admin.class))).thenReturn(anyInt());
        assertEquals(id,anyInt());
        assertNotNull(id);
        //verify(adminServiceImpl,times(1)).save(any(Admin.class));
    }

    @Test
    void delete() {
        int id = adminServiceImpl.delete(1);
        when(adminServiceImpl.save(any(Admin.class))).thenReturn(anyInt());
        assertNotNull(id);
        //verify(adminServiceImpl,times(1)).delete(anyInt());

    }

    @Test
    void login() {
        Admin admin=new Admin();
        admin.setName("admin10");
        admin.setPassword("111111");
        admin.setAdminId(0);
        Result result= adminServiceImpl.login(admin);
        assertNotNull(result);
    }
}
