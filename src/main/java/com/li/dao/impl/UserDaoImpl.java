package com.li.dao.impl;

import com.li.dao.IUserDao;
import com.li.domain.User;
import com.li.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Program: exam
 * @ClassName: UserDaoImpl
 * @Description:
 * @Author: li
 * @Create: 2019-07-23 09:59
 */
public class UserDaoImpl implements IUserDao {
    JdbcTemplate jt = new JdbcTemplate(JdbcUtils.getDs());

    @Override
    public List<User> queryAllUser() {
        String sql = "select * from user";
        return jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user values(?,?,?,?,?,?,?)";
        jt.update(sql, user.getEmail(), user.getUsername(), user.getPwd(), user.getSex(), user.getTel(), user.getAddress(), user.getStatus());
    }

    @Override
    public boolean checkEmail(String email) {
        String sql = "select count(1) from user where email like ?";
        Integer query = jt.queryForObject(sql, Integer.class, email);
        return query == 1 ? false : true;
    }

    @Override
    public boolean queryUser(User user) {
        String sql = "select count(1) from user where email like ? and pwd like ?";
        int total = jt.queryForObject(sql,Integer.class,user.getEmail(),user.getPwd());
        return total == 1 ? true : false;
    }

    @Override
    public void updateUserByEmail(User user) {
        String sql = "update user set username = ? ,sex = ? ,tel = ? ,address = ? where email like ?";
        jt.update(sql, user.getUsername(), user.getSex(), user.getTel(), user.getAddress(), user.getEmail());
    }

    @Override
    public User queryUserInfoByEmail(String email) {
        String sql = "select * from user where email like ?";
        return jt.query(sql, new BeanPropertyRowMapper<User>(User.class), email).get(0);
    }

    @Override
    public void changePwdByEmail(User user) {
        String sql = "update user set pwd = ? where email like ?";
        jt.update(sql, user.getPwd(), user.getEmail());
    }

    @Override
    public boolean queryPwdByEmail(User user) {
        String sql = "select pwd from user where email like ?";
        String pwd = jt.queryForObject(sql, String.class, user.getEmail());

        //两个密码相同，返回true
        return pwd.equals(user.getPwd()) ? true : false;
    }

    @Override
    public void delUserByEmail(String email) {
        String sql = "delete from user where email like ?";
        jt.update(sql, email);
    }

    @Override
    public void changStatus(String email, Integer status) {
        String sql = "update user set status = ? where email like ?";
        int newStatus = (status == 1) ? -1 : 1;
        jt.update(sql, newStatus, email);

    }

    @Override
    public List<User> BlackList() {
        String sql = "select * from user where status = -1";
        return jt.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public List<User> pageUser(int pageStart, int pageSize, Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder();
        List<Object> list = new ArrayList<>();
        sql.append("select * from user where 1 = 1");

        Set<String> sets = map.keySet();

        for (String set : sets) {
            if ("".equals(map.get(set)[0]) || "".equals(map.get(set)[0])) {
                continue;
            } else if ("currentPage".equals(set) || "pageSize".equals(set)) {
                continue;
            } else {
                sql.append(" and " + set + " like ?");
                list.add("%" + map.get(set)[0] + "%");
            }
        }

        sql.append(" limit ?,?");
        list.add(pageStart);
        list.add(pageSize);

        return jt.query(sql.toString(), new BeanPropertyRowMapper<User>(User.class), list.toArray());
    }

    @Override
    public int totalData(Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder();
        List<Object> list = new ArrayList<>();
        sql.append("select count(1) from user where 1 = 1");

        Set<String> sets = map.keySet();

        for (String set : sets) {
            if ("".equals(map.get(set)[0]) || "".equals(map.get(set)[0])) {
                continue;
            } else if ("currentPage".equals(set) || "pageSize".equals(set)) {
                continue;
            } else {
                sql.append(" and " + set + " like ?");
                list.add("%" + map.get(set)[0] + "%");
            }
        }

        return jt.queryForObject(sql.toString(), Integer.class, list.toArray());
    }

    @Override
    public int totalData() {
        String sql = "select count(1) from user";
        return jt.queryForObject(sql, Integer.class);
    }

    @Override
    public int totalBlack() {
        String sql = "select count(1) from user where status = -1";
        return jt.queryForObject(sql, Integer.class);
    }

    @Override
    public int totalBlack(Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder();
        List<Object> list = new ArrayList<>();
        sql.append("select count(1) from user where status = -1");

        Set<String> sets = map.keySet();

        for (String set : sets) {
            if ("".equals(map.get(set)[0]) || "".equals(map.get(set)[0])) {
                continue;
            } else if ("currentPage".equals(set) || "pageSize".equals(set)) {
                continue;
            } else {
                sql.append(" and " + set + " like ?");
                list.add("%" + map.get(set)[0] + "%");
            }
        }

        return jt.queryForObject(sql.toString(), Integer.class, list.toArray());
    }

    @Override
    public List<User> pageBlack(int pageStart, int pageSize,Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder();
        List<Object> list = new ArrayList<>();
        sql.append("select * from user where status = -1");

        Set<String> sets = map.keySet();

        for (String set : sets) {
            if ("".equals(map.get(set)[0]) || "".equals(map.get(set)[0])) {
                continue;
            } else if ("currentPage".equals(set) || "pageSize".equals(set)) {
                continue;
            } else {
                sql.append(" and " + set + " like ?");
                list.add("%" + map.get(set)[0] + "%");
            }
        }

        sql.append(" limit ?,?");
        list.add(pageStart);
        list.add(pageSize);

        return jt.query(sql.toString(), new BeanPropertyRowMapper<User>(User.class), list.toArray());
    }

    @Override
    public boolean queryStatus(String email) {
        String sql = "select status from user where email like ?";
        List<User> query = jt.query(sql, new BeanPropertyRowMapper<User>(User.class), email);
        return query.get(0).getStatus() == 1 ? true : false;
    }
}
