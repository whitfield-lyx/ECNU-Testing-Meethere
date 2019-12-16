package ecnu.testing.meethere.service;

import ecnu.testing.meethere.model.Message;
import ecnu.testing.meethere.model.MessageExample;

import java.util.List;

public interface MessageService {
    public Message selectByKey(Integer key);
    public int save(Message entity);
    public int delete(Integer key);
    public int updateAll(Message entity);
    public int updateNotNull(Message entity);
    public List<Message> selectByExample(MessageExample example);
}
