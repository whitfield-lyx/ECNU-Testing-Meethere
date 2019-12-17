package ecnu.testing.meethere.controller;

import ecnu.testing.meethere.model.*;
import ecnu.testing.meethere.service.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MessageController {
    @Autowired
    MessageServiceImpl messageServiceImpl;

    @GetMapping("/message")
    @ResponseStatus(HttpStatus.OK)
    public List<Message> getMessageList()
    {
        return messageServiceImpl.selectAllMessage();
    }

    @GetMapping("/message/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Message getMessageByID(@PathVariable("id") Integer id)
    {
        return messageServiceImpl.selectByKey(id);
    }

    @RequestMapping("/message")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMessage(@RequestBody Message message)
    {
        messageServiceImpl.save(message);
    }

    @DeleteMapping("/message/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public int deleteMessageByID(@PathVariable("id") Integer id){
        return  messageServiceImpl.delete(id);
    }
}
