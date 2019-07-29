package com.li.domain;

/**
 * @Program: exam
 * @ClassName: Order
 * @Description:
 * @Author: li
 * @Create: 2019-07-24 16:09
 */
public class Order {
    private int oid;
    private int cid;
    private String cname;
    private String email;
    private double crent;
    private String takeTime;
    private String getTime;
    private int status;

    public Order(int cid, String cname, String email, double crent, String takeTime, String getTime, int status) {
        this.cid = cid;
        this.cname = cname;
        this.email = email;
        this.crent = crent;
        this.takeTime = takeTime;
        this.getTime = getTime;
        this.status = status;
    }

    public Order(int oid, int cid, String cname, String email, double crent, String takeTime, String getTime, int status) {
        this.oid = oid;
        this.cid = cid;
        this.cname = cname;
        this.email = email;
        this.crent = crent;
        this.takeTime = takeTime;
        this.getTime = getTime;
        this.status = status;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                ", email='" + email + '\'' +
                ", crent=" + crent +
                ", takeTime='" + takeTime + '\'' +
                ", getTime='" + getTime + '\'' +
                ", status=" + status +
                '}';
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCrent() {
        return crent;
    }

    public void setCrent(double crent) {
        this.crent = crent;
    }

    public String getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(String takeTime) {
        this.takeTime = takeTime;
    }

    public String getGetTime() {
        return getTime;
    }

    public void setGetTime(String getTime) {
        this.getTime = getTime;
    }
}
