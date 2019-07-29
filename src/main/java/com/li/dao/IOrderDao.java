package com.li.dao;

import com.li.domain.Order;

import java.util.List;
import java.util.Map;

/**
 * @Program: exam
 * @ClassName: IOrderDao
 * @Description: 订单
 * @Author: li
 * @Create: 2019-07-24 16:12
 */
public interface IOrderDao {
    /**
     * @param order
     * @Description: 添加一个订单
     * @Author: li
     * @Create: 2019/7/24-16:12
     * @Return void
     */
    void addOrder(Order order);

    /**
     * @Description: 通过邮箱帐号，获取订单
     * @Author: li
     * @Create: 2019/7/24-16:56
     * @param
     * @Return java.util.List<com.li.domain.Order>
     */
    List<Order> queryOrderByEmail(String email,int status);

    /**
     * @Description: 将订单状态改为已还车 status:-1
     * @Author: li
     * @Create: 2019/7/24-18:52
     * @param  oid 订单号
     * @Return void
     */
    void reCar(int oid);

    /**
     * @Description: 分页加模糊查询,返回order
     * @Author: li
     * @Create: 2019/7/24-22:06
     * @param pageStart
     * @param pageSize
     * @param map
     * @Return java.util.List<com.li.domain.Order>
     */
    List<Order> pageOrder(int pageStart, int pageSize, Map<String, String[]> map);

    /**
     * @Description: 返回模糊查询的数据总数
     * @Author: li
     * @Create: 2019/7/23-20:57
     * @param map
     * @Return int
     */
    int totalData(Map<String, String[]> map);

    /**
     * @Description: 返回数据总数
     * @Author: li
     * @Create: 2019/7/25-15:26
     * @param
     * @Return int
     */
    int totalData();

    /**
     * @Description: 返回正在进行的订单
     * @Author: li
     * @Create: 2019/7/25-15:31
     * @param
     * @Return int
     */
    int orderOnline();


}
