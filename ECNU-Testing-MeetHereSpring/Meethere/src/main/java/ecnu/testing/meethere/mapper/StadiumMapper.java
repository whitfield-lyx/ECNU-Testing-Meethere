package ecnu.testing.meethere.mapper;

import ecnu.testing.meethere.model.Stadium;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StadiumMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..stadium
     *
     * @mbg.generated Fri Dec 20 13:13:15 CST 2019
     */
    int deleteByPrimaryKey(String stadiumId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..stadium
     *
     * @mbg.generated Fri Dec 20 13:13:15 CST 2019
     */
    int insert(Stadium record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..stadium
     *
     * @mbg.generated Fri Dec 20 13:13:15 CST 2019
     */
    int insertSelective(Stadium record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..stadium
     *
     * @mbg.generated Fri Dec 20 13:13:15 CST 2019
     */
    Stadium selectByPrimaryKey(String stadiumId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..stadium
     *
     * @mbg.generated Fri Dec 20 13:13:15 CST 2019
     */
    int updateByPrimaryKeySelective(Stadium record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..stadium
     *
     * @mbg.generated Fri Dec 20 13:13:15 CST 2019
     */
    int updateByPrimaryKey(Stadium record);
    List<Stadium> selectAllStadium();
}
