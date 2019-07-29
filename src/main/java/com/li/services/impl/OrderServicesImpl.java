package com.li.services.impl;

import com.li.dao.ICarDao;
import com.li.dao.IOrderDao;
import com.li.dao.impl.CarDaoImpl;
import com.li.dao.impl.OrderDaoImpl;
import com.li.domain.Order;
import com.li.domain.PageBean;
import com.li.services.IOrderServices;

import java.util.List;
import java.util.Map;

/**
 * @Program: exam
 * @ClassName: OrderServicesImpl
 * @Description:
 * @Author: li
 * @Create: 2019-07-24 16:19
 */
public class OrderServicesImpl implements IOrderServices {
    IOrderDao dao = new OrderDaoImpl();
    ICarDao cdao = new CarDaoImpl();

    @Override
    public void addOrder(Order order) {
        //将车辆状态改为租用 0
        cdao.changeCarStatus(order.getCid(),0);
        //将记录添加到数据库中
        dao.addOrder(order);
    }

    @Override
    public List<Order> queryOrderByEmail(String email,int status) {
        return dao.queryOrderByEmail(email,status);
    }

    @Override
    public void successOrder(Order order) {
        //将车辆状态改为上架 1
        cdao.changeCarStatus(order.getCid(),1);
        //更新订单状态，改为-1 订单已完成，已还车
        dao.reCar(order.getOid());
    }

    @Override
    public PageBean<Order> pageOrder(String _pageStart, String _pageSize, Map<String, String[]> map) {
        int pageStart = Integer.parseInt(_pageStart);
        int pageSize = Integer.parseInt(_pageSize);

        List<Order> orders = dao.pageOrder((pageStart - 1) * pageSize, pageSize, map);
        int totalData = dao.totalData(map);
        return new PageBean<Order>(pageStart, pageSize, totalData, orders);
    }
}
