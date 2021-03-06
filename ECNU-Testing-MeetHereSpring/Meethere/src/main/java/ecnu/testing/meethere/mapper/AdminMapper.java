package ecnu.testing.meethere.mapper;

import ecnu.testing.meethere.model.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..admin
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    int deleteByPrimaryKey(Integer adminId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..admin
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    int insert(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..admin
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    int insertSelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..admin
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    Admin selectByPrimaryKey(Integer adminId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..admin
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table meethere..admin
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    int updateByPrimaryKey(Admin record);
    Admin selectByName(String name);
}
