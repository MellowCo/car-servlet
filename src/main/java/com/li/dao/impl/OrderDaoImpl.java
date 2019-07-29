package com.li.dao.impl;

import com.li.dao.IOrderDao;
import com.li.domain.Order;
import com.li.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Program: exam
 * @ClassName: OrderDaoImpl
 * @Description: 订单
 * @Author: li
 * @Create: 2019-07-24 16:15
 */
public class OrderDaoImpl implements IOrderDao {
    JdbcTemplate jt = new JdbcTemplate(JdbcUtils.getDs());

    //添加订单
    @Override
    public void addOrder(Order order) {
        String sql = "insert into corder values(null,?,?,?,?,?,?,?)";
        jt.update(sql, order.getCid(), order.getCname(),order.getEmail(), order.getCrent(), order.getTakeTime(), order.getGetTime(), order.getStatus());
    }

    //通过邮箱帐号，获取订单
    @Override
    public List<Order> queryOrderByEmail(String email, int status) {
        String sql = "select * from corder where email like ? and status = ?";
        return jt.query(sql,new BeanPropertyRowMapper<Order>(Order.class),email,status);
    }

    //将订单状态改为已还车 status:-1
    @Override
    public void reCar(int oid) {
        String sql = "update corder set status = -1 where oid = ?";
        jt.update(sql,oid);
    }

    @Override
    public List<Order> pageOrder(int pageStart, int pageSize, Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder();
        List<Object> list = new ArrayList<>();
        sql.append("select * from corder where 1 = 1");

        Set<String> sets = map.keySet();

        for (String set : sets) {
            if ("".equals(map.get(set)[0]) || "".equals(map.get(set)[0])) {
                continue;
            } else if ("currentPage".equals(set) || "pageSize".equals(set)) {
                continue;
            } else if ("status".equals(set)) {
                sql.append(" and " + set + " like ?");
                list.add(map.get(set)[0]);
            } else {
                sql.append(" and " + set + " like ?");
                list.add("%" + map.get(set)[0] + "%");
            }
        }

        sql.append(" limit ?,?");
        list.add(pageStart);
        list.add(pageSize);

        return jt.query(sql.toString(), new BeanPropertyRowMapper<Order>(Order.class), list.toArray());
    }

    @Override
    public int totalData(Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder();
        List<Object> list = new ArrayList<>();
        sql.append("select count(1) from corder where 1 = 1");

        Set<String> sets = map.keySet();

        for (String set : sets) {
            if ("".equals(map.get(set)[0]) || "".equals(map.get(set)[0])) {
                continue;
            } else if ("currentPage".equals(set) || "pageSize".equals(set)) {
                continue;
            } else if ("status".equals(set)) {
                sql.append(" and " + set + " like ?");
                list.add(map.get(set)[0]);
            } else {
                sql.append(" and " + set + " like ?");
                list.add("%" + map.get(set)[0] + "%");
            }
        }

        return jt.queryForObject(sql.toString(), Integer.class, list.toArray());
    }

    @Override
    public int totalData() {
        String sql = "select count(1) from corder";
        return jt.queryForObject(sql, Integer.class);
    }

    @Override
    public int orderOnline() {
        String sql = "select count(1) from corder where status = 1";
        return jt.queryForObject(sql, Integer.class);
    }


}
