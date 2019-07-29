package com.li.dao.impl;

import com.li.dao.ICarDao;
import com.li.domain.Car;
import com.li.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Program: exam
 * @ClassName: CarDaoImpl
 * @Description:
 * @Author: li
 * @Create: 2019-07-24 13:13
 */
public class CarDaoImpl implements ICarDao {
    JdbcTemplate jt = new JdbcTemplate(JdbcUtils.getDs());

    //返回所有的车辆信息
    @Override
    public List<Car> queryAllCar() {
        String sql = "select * from  carport where status = 1 order by cname";
        return jt.query(sql, new BeanPropertyRowMapper<Car>(Car.class));
    }

    //按租金倒序
    @Override
    public List<Car> queryAllCarByRentDesc() {
        String sql = "select * from  carport where status = 1 order by crent desc";
        return jt.query(sql, new BeanPropertyRowMapper<Car>(Car.class));
    }

    //按租金升序
    @Override
    public List<Car> queryAllCarByRentAsc() {
        String sql = "select * from carport where status = 1  order by crent";
        return jt.query(sql, new BeanPropertyRowMapper<Car>(Car.class));
    }

    //根据车名模糊查询
    @Override
    public List<Car> fuzzyQueryByCar(String name) {
        String sql = "select * from carport where status = 1 and cname like ?";
        String str = "%" + name + "%";
        return jt.query(sql, new BeanPropertyRowMapper<Car>(Car.class), str);

    }

    //根据车辆id 返回 car
    @Override
    public Car queryCarById(int id) {
        String sql = "select * from carport where cid = ?";
        return jt.query(sql, new BeanPropertyRowMapper<Car>(Car.class), id).get(0);
    }

    //更改车辆状态
    @Override
    public void changeCarStatus(int id, int status) {
        String sql = "update carport set status = ? where cid = ?";
        jt.update(sql, status, id);
    }

    //分页加模糊查询,返回car
    @Override
    public List<Car> pageCar(int pageStart, int pageSize, Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder();
        List<Object> list = new ArrayList<>();
        sql.append("select * from carport where status != 0");

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

        return jt.query(sql.toString(), new BeanPropertyRowMapper<Car>(Car.class), list.toArray());
    }

    //返回模糊查询的数据总数
    @Override
    public int totalData(Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder();
        List<Object> list = new ArrayList<>();
        sql.append("select count(1) from carport where status != 0");

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

    //下架
    @Override
    public void changCarDown(int cid) {
        String sql = "update carport set status = -1 where cid = ?";
        jt.update(sql, cid);
    }

    //添加新车
    @Override
    public void addCar(Car car) {
        String sql = "insert into carport values(null,?,?,?,?,?)";
        jt.update(sql, car.getCimg(), car.getCinfo(), car.getCname(), car.getCrent(), car.getStatus());
    }

    @Override
    public int totalCar() {
        String sql = "select count(1) from carport";
        return jt.queryForObject(sql, Integer.class);
    }


}
