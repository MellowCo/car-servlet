package com.li.domain;

/**
 * @Program: exam
 * @ClassName: User
 * @Description: 用户的实体类
 * @Author: li
 * @Create: 2019-07-23 09:54
 */
public class User {
    private String email;
    private String username;
    private String pwd;
    private String sex;
    private String tel;
    private String address;
    private Integer status;

    public User(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }

    public User(String email, String username, String pwd, String sex, String tel, String address, Integer status) {
        this.email = email;
        this.username = username;
        this.pwd = pwd;
        this.sex = sex;
        this.tel = tel;
        this.address = address;
        this.status = status;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
