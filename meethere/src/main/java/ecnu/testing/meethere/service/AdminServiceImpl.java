package ecnu.testing.meethere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends BaseService<AdminService> implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
}
