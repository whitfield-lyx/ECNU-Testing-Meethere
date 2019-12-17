package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.UserMapper;
import ecnu.testing.meethere.model.User;
import ecnu.testing.meethere.model.UserExample;
import ecnu.testing.meethere.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectByKey(Integer key) {
        return userMapper.selectByPrimaryKey(key);
    }

    @Override
    public int save(User entity) {
        return userMapper.insert(entity);
    }

    @Override
    public int delete(Integer key) {
        return userMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int updateAll(User entity) {
        return userMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateNotNull(User entity) {
        return userMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<User> selectByExample(UserExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public Result login(User user){
        Integer id = user.getUserId();
        System.out.println("user id is "+id+" password is "+user.getPassword());
        User myUser = selectByKey(id);
        if(myUser == null){
            return ResultFactory.buildFailResult("不存在该用户名");
        }
        if(!myUser.getPassword().equals(user.getPassword())){
            return ResultFactory.buildFailResult("用户名或密码错误");
        }else {
            return ResultFactory.buildSuccessResult("用户登录成功");
        }
    }
}
