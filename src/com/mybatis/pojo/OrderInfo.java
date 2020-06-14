package com.mybatis.pojo;


import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @Classname OrderInfo
 * @Description TODO
 * @Author 将烬星火是否太炽热, 明日黄花会开败阡陌
 * @Date 2020-06-06 14:31
 * @Version 1.0
 **/
public class OrderInfo {

    private Integer id;
    private String order_code;
    private String order_name;
    private Integer order_status;
    private Date regDate;

    @Override
    public String toString() {
        return "订单信息[订单编码: " + order_code + ", " +
                "订单备注: " + order_name + ", " +
                "订单状态: " + order_status + ", " +
                "创建时间: " + regDate + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
