package ecnu.testing.meethere.model;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meethere..user.user_id
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meethere..user.password
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meethere..user.name
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meethere..user.nickname
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    private String nickname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meethere..user.user_id
     *
     * @return the value of meethere..user.user_id
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meethere..user.user_id
     *
     * @param userId the value for meethere..user.user_id
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meethere..user.password
     *
     * @return the value of meethere..user.password
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meethere..user.password
     *
     * @param password the value for meethere..user.password
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meethere..user.name
     *
     * @return the value of meethere..user.name
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meethere..user.name
     *
     * @param name the value for meethere..user.name
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meethere..user.nickname
     *
     * @return the value of meethere..user.nickname
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meethere..user.nickname
     *
     * @param nickname the value for meethere..user.nickname
     *
     * @mbg.generated Mon Dec 16 21:18:55 CST 2019
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

}
