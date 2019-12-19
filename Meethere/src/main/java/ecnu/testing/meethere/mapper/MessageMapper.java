package ecnu.testing.meethere.mapper;

import ecnu.testing.meethere.model.Message;
import ecnu.testing.meethere.model.MessageExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..message
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    int deleteByPrimaryKey(Integer messageId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..message
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    int insert(Message record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..message
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    int insertSelective(Message record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..message
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    List<Message> selectByExample(MessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..message
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    Message selectByPrimaryKey(Integer messageId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..message
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    int updateByPrimaryKeySelective(Message record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..message
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    int updateByPrimaryKey(Message record);

    List<Message> selectAllMessage();
    int updateIsChecked(Integer messageId);
}
