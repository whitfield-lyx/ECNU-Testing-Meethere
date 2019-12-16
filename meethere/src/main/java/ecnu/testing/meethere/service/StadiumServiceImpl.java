package ecnu.testing.meethere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StadiumServiceImpl extends BaseService<StadiumService> implements StadiumService {
    @Autowired
    private StadiumMapper stadiumMapper;
}
