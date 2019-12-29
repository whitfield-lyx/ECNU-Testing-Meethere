package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.UserMapper;
import ecnu.testing.meethere.model.User;
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
public class UserServiceImplTest {
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Before
    public void  setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @org.junit.Test
    public void  login() {
        User user = new User();
        user.setName("user01");
        user.setPassword("apple");
        userServiceImpl.login(user);
    }

    @org.junit.Test
    public void  save() {
        User user = new User();
        user.setName("user01");
        user.setPassword("apple");
        user.setNickname("1231asda");
        user.setUserId(5);
        userServiceImpl.save(user);
    }

    @org.junit.Test
    public void  selectByKey() {
        userServiceImpl.selectByKey(5);
    }

    @org.junit.Test
    public void  updatePassword() {
        User user = new User();
        user.setName("user01");
        user.setPassword("apple");
        user.setNickname("1231asda");
        user.setUserId(5);
        userServiceImpl.updatePassword(5,user);
    }

    @Test
    public void  selectAllUser() {
        userServiceImpl.selectAllUser();
    }
}
