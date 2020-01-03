package ecnu.testing.meethere.service;


import ecnu.testing.meethere.mapper.UserMapper;
import ecnu.testing.meethere.model.User;
import ecnu.testing.meethere.util.Result;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

//@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class UserServiceImplTest {
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @BeforeEach
    public void  setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void  login() {
        User user = new User();
        user.setName("user01");
        user.setPassword("apple");
        when(userMapper.selectByPrimaryKey(0)).thenReturn(user);
        Result result = userServiceImpl.login(user);
        assertNotNull(result);
    }

    @Test
    public void  save() {
        User user = new User();
        user.setName("user01");
        user.setPassword("apple");
        user.setNickname("1231asda");
        user.setUserId(5);
        when(userMapper.insert(user)).thenReturn(1);
        userServiceImpl.save(user);
        assertNotNull(user);
    }

    @Test
    public void  selectByKey() {
        userServiceImpl.selectByKey(5);
        User user = new User();
        user.setName("user01");
        user.setPassword("apple");
        user.setNickname("1231asda");
        user.setUserId(5);
        when(userServiceImpl.selectByKey(5)).thenReturn(user);
        assertNotNull(user);
    }

    @Test
    public void  updatePassword() {
        User user = new User();
        user.setName("user01");
        user.setPassword("apple");
        user.setNickname("1231asda");
        user.setUserId(5);
        when(userServiceImpl.updatePassword(5,user)).thenReturn(null);
        assertNotNull(user);
    }

    @Test
    public void  selectAllUser() {
        List<User> users = Lists.newArrayList();
        when(userServiceImpl.selectAllUser()).thenReturn(users);
        assertNotNull(users);
    }
}
