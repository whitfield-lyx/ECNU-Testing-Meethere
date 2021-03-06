package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.UserMapper;
import ecnu.testing.meethere.model.User;
import ecnu.testing.meethere.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectByKey(Integer key) {
        return userMapper.selectByPrimaryKey(key);
    }

    @Override
    public Result save(User user) {
        List<User> userList = userMapper.selectByName(user.getName());
        if(userList.isEmpty()){
            userMapper.insert(user);
            return ResultFactory.buildSuccessResult("用户注册成功");
        }
        else {
            //System.out.println(userList);
            return ResultFactory.buildFailResult("已存在该用户名的用户");
        }
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
    public Result login(User user){
        /* 此处只含有name与password信息 */
        String name= user.getName();
        //System.out.println("user name is "+name+" password is "+user.getPassword());
        List<User> userList = userMapper.selectByName(name);
        /* post condition: userList长度为0或1 */
        if(userList == null || userList.isEmpty()){
            return ResultFactory.buildFailResult("不存在该用户名");
        }
        User myUser = userList.get(0);
        if(!myUser.getPassword().equals(user.getPassword())){
            return ResultFactory.buildFailResult("用户名或密码错误");
        }else {
            return ResultFactory.buildSuccessResult("用户登录成功");
        }
    }

    @Override
    public int updatePassword(Integer userId, User user) {
        String password = user.getPassword();
        User oldUser = selectByKey(userId);
        if (oldUser == null){
            Logger logger = (Logger) LoggerFactory.getLogger(getClass());
            logger.info("不存在该用户");
            //System.err.println("不存在该用户");
            return -1;
        }
        //System.out.println("userId: "+userId+" old password: "+user.getPassword());
        oldUser.setPassword(password);
        //System.out.println("userId: "+userId+" new password: "+password);
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public String getNickname(Integer userId) {
        return selectByKey(userId).getNickname();
    }

    @Override
    public Integer getIdByName(String name) {
        List<User> userList = userMapper.selectByName(name);
        /* post condition: userList长度为0或1 */
        if(userList==null){
            Logger logger = (Logger) LoggerFactory.getLogger(getClass());
            logger.info("不存在该用户名");
            //System.out.println("不存在该用户名");
            return 0;
        }
        else if(userList.size()==1&&userList.get(0)!=null){
            return userList.get(0).getUserId();
        }
        return -1;
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public int updatePasswordByAdmin(User user) {
        Logger logger = (Logger) LoggerFactory.getLogger(getClass());
        logger.info("userId: "+user.getUserId()+" new password: "+user.getPassword());
        //System.out.println("userId: "+user.getUserId()+" new password: "+user.getPassword());
        return userMapper.updateByPrimaryKey(user);
    }
}
