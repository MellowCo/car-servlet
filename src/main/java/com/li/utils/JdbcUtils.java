package com.li.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Program: exam
 * @ClassName: JdbcUtils
 * @Description: 数据库工具类
 * @Author: li
 * @Create: 2019-07-23 09:00
 */
public class JdbcUtils {
    private static DataSource ds = null;

    static {
        Properties pro = new Properties();
        InputStream path = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc_config.properties");
        try {
            pro.load(path);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDs(){
        return ds;
    }
}
