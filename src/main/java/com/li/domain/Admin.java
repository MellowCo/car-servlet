package com.li.domain;

/**
 * @Program: exam
 * @ClassName: Admin
 * @Description: 管理员
 * @Author: li
 * @Create: 2019-07-24 09:42
 */
public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Admin() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
