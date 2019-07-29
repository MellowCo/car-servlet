package com.li.dao.impl;

import com.li.dao.IAdminDao;
import com.li.domain.Admin;
import com.li.utils.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Program: exam
 * @ClassName: AdminDaoImpl
 * @Description:
 * @Author: li
 * @Create: 2019-07-24 09:47
 */
public class AdminDaoImpl implements IAdminDao {
    JdbcTemplate jt = new JdbcTemplate(JdbcUtils.getDs());
    @Override
    public boolean queryAdminByUsername(String username) {
        String sql = "select count(1) from admin where username like ?";
        int total = jt.queryForObject(sql,Integer.class,username);
        return total == 1 ? true : false;
    }

    @Override
    public boolean queryAdmin(Admin admin) {
        String sql = "select count(1) from admin where username like ? and password like ?";
        int total = jt.queryForObject(sql,Integer.class,admin.getUsername(),admin.getPassword());
        return total == 1 ? true : false;
    }
}
