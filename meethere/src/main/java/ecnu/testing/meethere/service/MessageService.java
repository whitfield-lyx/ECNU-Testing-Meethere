package ecnu.testing.meethere.service;

import ecnu.testing.meethere.model.Message;
import ecnu.testing.meethere.model.MessageExample;
import ecnu.testing.meethere.util.MessageInfo;
import ecnu.testing.meethere.util.Result;

import java.util.List;

public interface MessageService {
    public Message selectByKey(Integer key);
    public int save(Message entity);
    public int delete(Integer key);
    public int updateAll(Message entity);
    public int updateNotNull(Message entity);
    public List<Message> selectByExample(MessageExample example);

    public List<MessageInfo> selectAllMessage();
    public int checkMessage(Integer messageId);
    public Result updateMessage(Integer userId,Integer messageId,String content);
}
