package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.*;
import ecnu.testing.meethere.service.MessageServiceImpl;
import ecnu.testing.meethere.util.MessageInfo;
import ecnu.testing.meethere.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MessageController {
    final
    MessageServiceImpl messageServiceImpl;

    public MessageController(MessageServiceImpl messageServiceImpl) {
        this.messageServiceImpl = messageServiceImpl;
    }

    /**
     * 获取所有留言
     */
    @GetMapping("/message")
    @ResponseStatus(HttpStatus.OK)
    public List<MessageInfo> getMessageList()
    {
        return messageServiceImpl.selectAllMessage();
    }

    /**
     * 获取指定留言 仅测试用
     */
    @GetMapping("/message/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Message getMessageByID(@PathVariable("id") Integer id)
    {
        return messageServiceImpl.selectByKey(id);
    }

    /**
     * 用户 发表一个留言
     */
    @PostMapping("/message")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMessage(@SessionAttribute Integer userId, @RequestBody Message message)
    {
        message.setUserId(userId);
        messageServiceImpl.save(message);
    }

    /**
     * 管理员 删除某个留言
     */
    @DeleteMapping("/message/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public int deleteMessageByID(@PathVariable("id") Integer id){
        return messageServiceImpl.delete(id);
    }

    /**
     * 管理员 审核通过某个留言
     */
    @PutMapping("/message/check/{id}")
    public int checkMessage(@PathVariable("id") Integer messageId)
    {
        return messageServiceImpl.checkMessage(messageId);
    }

    /**
     * 用户 修改留言 仅可修改自己发表的留言
     */
    @PutMapping("/message/update/{id}")
    public Result updateMessage(@SessionAttribute Integer userId, @PathVariable("id") Integer messageId, @RequestBody Message message){
        /* 仅修改 content 字段*/
        return messageServiceImpl.updateMessage(userId, messageId, message);
    }
}
