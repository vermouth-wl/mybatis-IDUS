package com.mybatis.pojo;

import java.util.Date;

/**
 * @Classname UserInfo
 * @Description TODO
 * @Author 将烬星火是否太炽热, 明日黄花会开败阡陌
 * @Date 2020-05-31 17:20
 * @Version 1.0
 **/
public class UserInfo {
    private Integer id;
    private String user_code;
    private String user_name;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Date regDate;
    private Integer status;

    @Override
    public String toString() {
        return "用户信息[用户编码: " + user_code + ", " +
                "用户姓名: " + user_name + ", " +
                "密码: " + password + ", " +
                "姓名: " + name + "," +
                "邮箱: " + email + ", " +
                "电话: " + phone + ", " +
                "地址: " + address + ", " +
                "注册时间: " + regDate + ", " +
                "状态: " + status + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
