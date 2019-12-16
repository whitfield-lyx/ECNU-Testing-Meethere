package ecnu.testing.meethere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService<UserService> implements UserService {
    @Autowired
    private UserMapper userMapper;
}
