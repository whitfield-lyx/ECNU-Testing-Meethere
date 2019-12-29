package ecnu.testing.meethere.service;

import ecnu.testing.meethere.mapper.*;
import ecnu.testing.meethere.model.*;
import ecnu.testing.meethere.util.MessageInfo;
import ecnu.testing.meethere.util.Result;
import ecnu.testing.meethere.util.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
        entity.setTime(new Date());
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

    @Override
    public Result updateMessage(Integer userId, Integer messageId, Message message) {
        String content = message.getContent();
        Message oldMessage = messageMapper.selectByPrimaryKey(messageId);
        if(oldMessage == null || !userId.equals(oldMessage.getUserId())){
            return ResultFactory.buildFailResult("只能修改自己发布的留言！");
        }
        oldMessage.setContent(content);
        oldMessage.setTime(new Date());
        messageMapper.updateByPrimaryKey(oldMessage);
        return ResultFactory.buildSuccessResult("修改留言成功");
    }
}
