package ecnu.testing.meethere.service;

import ecnu.testing.meethere.model.User;
import ecnu.testing.meethere.model.UserExample;

import java.util.List;

public interface UserService {
    public User selectByKey(Integer key);
    public int save(User entity);
    public int delete(Integer key);
    public int updateAll(User entity);
    public int updateNotNull(User entity);
    public List<User> selectByExample(UserExample example);
}
