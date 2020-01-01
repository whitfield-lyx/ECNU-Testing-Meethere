package ecnu.testing.meethere.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import ecnu.testing.meethere.model.Order;
import ecnu.testing.meethere.model.Stadium;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.logging.Logger;

public class OrderInfo {
    private Integer orderId;
    private Integer userId;
    private String stadiumId;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;
    private Byte isChecked;
    private String address;
    private Integer price;

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    private Integer hour;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(String stadiumId) {
        this.stadiumId = stadiumId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Byte getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Byte isChecked) {
        this.isChecked = isChecked;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public OrderInfo(Order order, Stadium stadium){
        this.orderId = order.getOrderId();
        this.userId = order.getUserId();
        this.stadiumId = order.getStadiumId();
        this.time = order.getTime();
        this.isChecked = order.getIsChecked();
        this.address = stadium.getAddress();
        this.price = stadium.getPrice();
        this.hour = order.getHour();
    }

    public void display(){
        Logger logger = (Logger) LoggerFactory.getLogger(getClass());
        logger.info("orderId: "+orderId+" userId: "+userId+" stadiumId: "+stadiumId+" time: "
                 +time+" isChecked: "+isChecked+" address: "+address+" price: "+price);
        //System.out.println("orderId: "+orderId+" userId: "+userId+" stadiumId: "+stadiumId+" time: "
               // +time+" isChecked: "+isChecked+" address: "+address+" price: "+price);
    }
}
