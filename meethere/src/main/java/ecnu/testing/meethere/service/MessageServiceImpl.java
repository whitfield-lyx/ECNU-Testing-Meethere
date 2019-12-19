package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.*;
import ecnu.testing.meethere.model.*;
import ecnu.testing.meethere.util.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UserMapper userMapper;

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

    @Override
    public List<MessageInfo> selectAllMessage(){
        List<Message> messageList = messageMapper.selectAllMessage();
        List<MessageInfo> messageInfoList = new ArrayList<MessageInfo>();
        for(Message message : messageList){
            User user = userMapper.selectByPrimaryKey(message.getUserId());
            //System.out.println("nickname: "+user.getNickname());
            messageInfoList.add(new MessageInfo(message, user.getNickname()));
        }
        return messageInfoList;
    }

    @Override
    public int checkMessage(Integer messageId) {
        return messageMapper.updateIsChecked(messageId);
    }
}
