package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.MessageMapper;
import ecnu.testing.meethere.model.Message;
import ecnu.testing.meethere.model.MessageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Message selectByKey(Integer key) {
        return messageMapper.selectByPrimaryKey(key);
    }

    @Override
    public int save(Message entity) {
        return messageMapper.insert(entity);
    }

    @Override
    public int delete(Integer key) {
        return messageMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int updateAll(Message entity) {
        return messageMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateNotNull(Message entity) {
        return messageMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<Message> selectByExample(MessageExample example) {
        return messageMapper.selectByExample(example);
    }
}
