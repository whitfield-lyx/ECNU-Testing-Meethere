package ecnu.testing.meethere.model;

import java.util.Date;

public class Stadium {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meethere..stadium.auto_incr
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    private Integer autoIncr;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meethere..stadium.stadium_id
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    private String stadiumId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meethere..stadium.time
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    private Date time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meethere..stadium.price
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    private Integer price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meethere..stadium.address
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    private String address;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meethere..stadium.auto_incr
     *
     * @return the value of meethere..stadium.auto_incr
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public Integer getAutoIncr() {
        return autoIncr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meethere..stadium.auto_incr
     *
     * @param autoIncr the value for meethere..stadium.auto_incr
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public void setAutoIncr(Integer autoIncr) {
        this.autoIncr = autoIncr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meethere..stadium.stadium_id
     *
     * @return the value of meethere..stadium.stadium_id
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public String getStadiumId() {
        return stadiumId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meethere..stadium.stadium_id
     *
     * @param stadiumId the value for meethere..stadium.stadium_id
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public void setStadiumId(String stadiumId) {
        this.stadiumId = stadiumId == null ? null : stadiumId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meethere..stadium.time
     *
     * @return the value of meethere..stadium.time
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meethere..stadium.time
     *
     * @param time the value for meethere..stadium.time
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meethere..stadium.price
     *
     * @return the value of meethere..stadium.price
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meethere..stadium.price
     *
     * @param price the value for meethere..stadium.price
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meethere..stadium.address
     *
     * @return the value of meethere..stadium.address
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meethere..stadium.address
     *
     * @param address the value for meethere..stadium.address
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}