package ecnu.testing.meethere.mapper;

import ecnu.testing.meethere.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..order
     *
     * @mbg.generated Wed Dec 18 15:54:14 CST 2019
     */
    int deleteByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..order
     *
     * @mbg.generated Wed Dec 18 15:54:14 CST 2019
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..order
     *
     * @mbg.generated Wed Dec 18 15:54:14 CST 2019
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..order
     *
     * @mbg.generated Wed Dec 18 15:54:14 CST 2019
     */
    Order selectByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..order
     *
     * @mbg.generated Wed Dec 18 15:54:14 CST 2019
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..order
     *
     * @mbg.generated Wed Dec 18 15:54:14 CST 2019
     */
    int updateByPrimaryKey(Order record);

    List<Order> selectAllOrder();
    int updateIsChecked(Integer orderId);
    List<Order> selectMyOrder(Integer userId);

}
