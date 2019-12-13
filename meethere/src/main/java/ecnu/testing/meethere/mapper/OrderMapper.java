package ecnu.testing.meethere.mapper;

import ecnu.testing.meethere.model.Order;
import ecnu.testing.meethere.model.OrderExample;
import java.util.List;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..order
     *
     * @mbg.generated Fri Dec 13 20:19:57 CST 2019
     */
    int deleteByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..order
     *
     * @mbg.generated Fri Dec 13 20:19:57 CST 2019
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..order
     *
     * @mbg.generated Fri Dec 13 20:19:57 CST 2019
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..order
     *
     * @mbg.generated Fri Dec 13 20:19:57 CST 2019
     */
    List<Order> selectByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..order
     *
     * @mbg.generated Fri Dec 13 20:19:57 CST 2019
     */
    Order selectByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..order
     *
     * @mbg.generated Fri Dec 13 20:19:57 CST 2019
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..order
     *
     * @mbg.generated Fri Dec 13 20:19:57 CST 2019
     */
    int updateByPrimaryKey(Order record);
}