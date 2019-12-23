package ecnu.testing.meethere.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import ecnu.testing.meethere.model.Message;
import ecnu.testing.meethere.model.User;

import java.util.Date;

public class MessageInfo {
    private Integer messageId;
    private Integer userId;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String content;
    private Byte isChecked;
    private String nickname;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Byte getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Byte isChecked) {
        this.isChecked = isChecked;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public MessageInfo(Message message, String nickname){
        this.messageId = message.getMessageId();
        this.userId = message.getUserId();
        this.time = message.getTime();
        this.content = message.getContent();
        this.isChecked = message.getIsChecked();
        this.nickname = nickname;
    }
}
