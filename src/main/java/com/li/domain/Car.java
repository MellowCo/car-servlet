package com.li.domain;

/**
 * @Program: exam
 * @ClassName: Car
 * @Description:
 * @Author: li
 * @Create: 2019-07-24 13:07
 */
public class Car {
    //车辆编号
    private int cid;
    //车辆图片
    private String cimg;
    //车辆信息
    private String cinfo;
    //车辆名称
    private String cname;
    //车辆租金
    private double crent;
    //车辆状态 -1 下架 ；0 出租 ；1 可租
    private int status;

    public Car(int cid, String cimg, String cinfo, String cname, double crent, int status) {
        this.cid = cid;
        this.cimg = cimg;
        this.cinfo = cinfo;
        this.cname = cname;
        this.crent = crent;
        this.status = status;
    }

    public Car(String cimg, String cinfo, String cname, double crent, int status) {
        this.cimg = cimg;
        this.cinfo = cinfo;
        this.cname = cname;
        this.crent = crent;
        this.status = status;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "cid=" + cid +
                ", cimg='" + cimg + '\'' +
                ", cinfo='" + cinfo + '\'' +
                ", cname='" + cname + '\'' +
                ", crent=" + crent +
                ", status=" + status +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCimg() {
        return cimg;
    }

    public void setCimg(String cimg) {
        this.cimg = cimg;
    }

    public String getCinfo() {
        return cinfo;
    }

    public void setCinfo(String cinfo) {
        this.cinfo = cinfo;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getCrent() {
        return crent;
    }

    public void setCrent(double crent) {
        this.crent = crent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
