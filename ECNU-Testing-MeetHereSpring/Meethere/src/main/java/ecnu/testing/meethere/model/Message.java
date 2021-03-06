package ecnu.testing.meethere.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Message {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meethere..message.message_id
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    private Integer messageId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meethere..message.user_id
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meethere..message.time
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meethere..message.content
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meethere..message.is_checked
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    private Byte isChecked;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meethere..message.message_id
     *
     * @return the value of meethere..message.message_id
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meethere..message.message_id
     *
     * @param messageId the value for meethere..message.message_id
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meethere..message.user_id
     *
     * @return the value of meethere..message.user_id
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meethere..message.user_id
     *
     * @param userId the value for meethere..message.user_id
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meethere..message.time
     *
     * @return the value of meethere..message.time
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meethere..message.time
     *
     * @param time the value for meethere..message.time
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meethere..message.content
     *
     * @return the value of meethere..message.content
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meethere..message.content
     *
     * @param content the value for meethere..message.content
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meethere..message.is_checked
     *
     * @return the value of meethere..message.is_checked
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public Byte getIsChecked() {
        return isChecked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meethere..message.is_checked
     *
     * @param isChecked the value for meethere..message.is_checked
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public void setIsChecked(Byte isChecked) {
        this.isChecked = isChecked;
    }

    public Message(Integer messageId, Integer userId, Date time, String content, Byte isChecked) {
        this.messageId = messageId;
        this.userId = userId;
        this.time = time;
        this.content = content;
        this.isChecked = isChecked;
    }

    public Message() {
    }
}
