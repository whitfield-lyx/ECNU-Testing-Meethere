package ecnu.testing.meethere.service;

import ecnu.testing.meethere.model.User;
import ecnu.testing.meethere.model.UserExample;
import ecnu.testing.meethere.util.*;

import java.util.List;

public interface UserService {
    public User selectByKey(Integer key);
    public int save(User entity);
    public int delete(Integer key);
    public int updateAll(User entity);
    public int updateNotNull(User entity);
    public List<User> selectByExample(UserExample example);

    public Result login(User user);
    public int updatePassword(Integer userId, String password);
    public String getNickname(Integer userId);
}
