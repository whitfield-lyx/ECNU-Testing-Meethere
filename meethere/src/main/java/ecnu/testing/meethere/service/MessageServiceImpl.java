package ecnu.testing.meethere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends BaseService<MessageService> implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
}
