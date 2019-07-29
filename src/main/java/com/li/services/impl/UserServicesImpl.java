package com.li.services.impl;

import com.li.dao.IUserDao;
import com.li.dao.impl.UserDaoImpl;
import com.li.domain.PageBean;
import com.li.domain.User;
import com.li.services.IUserServices;

import java.util.List;
import java.util.Map;

/**
 * @Program: exam
 * @ClassName: UserServicesImpl
 * @Description:
 * @Author: li
 * @Create: 2019-07-23 10:02
 */
public class UserServicesImpl implements IUserServices {
    IUserDao dao = new UserDaoImpl();

    @Override
    public List<User> queryAllUser() {
        return dao.queryAllUser();
    }

    @Override
    public void register(User user) {
        dao.addUser(user);
    }

    @Override
    public boolean checkEmail(String email) {
        return dao.checkEmail(email);
    }

    @Override
    public void updateUserByEmail(User user) {
        dao.updateUserByEmail(user);
    }

    @Override
    public User queryUserInfoByEmail(String email) {
        return dao.queryUserInfoByEmail(email);
    }

    @Override
    public void changePwdByEmail(User user) {
        dao.changePwdByEmail(user);
    }

    @Override
    public boolean queryPwdByEmail(User user) {
        return dao.queryPwdByEmail(user);
    }

    @Override
    public void delUserByEmail(String email) {
        dao.delUserByEmail(email);
    }

    @Override
    public void changStatus(String email, Integer status) {
        dao.changStatus(email,status);
    }

    @Override
    public List<User> BlackList() {
        return dao.BlackList();
    }

    @Override
    public PageBean<User> pageUser(String _pageStart, String _pageSize, Map<String, String[]> map) {
        int pageStart = Integer.parseInt(_pageStart);
        int pageSize = Integer.parseInt(_pageSize);

        List<User> users = dao.pageUser((pageStart - 1) * pageSize, pageSize, map);
        int totalData = dao.totalData(map);
        return new PageBean<User>(pageStart, pageSize, totalData, users);
    }

    @Override
    public int totalData() {
        return dao.totalData();
    }

    @Override
    public PageBean<User> pageBlack(String _pageStart, String _pageSize,Map<String, String[]> map) {
        int pageStart = Integer.parseInt(_pageStart);
        int pageSize = Integer.parseInt(_pageSize);

        List<User> users = dao.pageBlack((pageStart - 1) * pageSize, pageSize,map);
        int totalData = dao.totalBlack(map);
        return new PageBean<User>(pageStart, pageSize, totalData, users);
    }

    @Override
    public int userLogin(User user) {
        if(!dao.checkEmail(user.getEmail())){
            if(dao.queryUser(user)){
                if(dao.queryStatus(user.getEmail())){
                    //登陆成功
                    return 1;
                }else{
                    //你被管理员拉黑
                    return -2;
                }
            }else {
                //密码错误
                return -1;
            }
        }else{
            //帐号不存在
            return 0;
        }
    }

}
