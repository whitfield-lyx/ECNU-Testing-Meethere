package ecnu.testing.meethere.service;

import ecnu.testing.meethere.model.User;
import ecnu.testing.meethere.model.UserExample;
import ecnu.testing.meethere.util.*;

import java.util.List;

public interface UserService {
    public User selectByKey(Integer key);
    public Result save(User user);
    public int delete(Integer key);
    public int updateAll(User entity);
    public int updateNotNull(User entity);
    public List<User> selectByExample(UserExample example);

    public Result login(User user);
    public int updatePassword(Integer userId, User user);
    public String getNickname(Integer userId);
    public Integer getIdByName(String name);

    public List<User> selectAllUser();
    public int updatePasswordByAdmin(User user);
}
