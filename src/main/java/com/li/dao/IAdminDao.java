package com.li.dao;

import com.li.domain.Admin;

/**
 * @Program: exam
 * @ClassName: IAdminDao
 * @Description:
 * @Author: li
 * @Create: 2019-07-24 09:44
 */
public interface IAdminDao {
    /**
     * @Description: 查看管理员是否存在
     * @Author: li
     * @Create: 2019/7/24-9:45
     * @param username
     * @Return boolean true:存在
     */
    boolean queryAdminByUsername(String username);

    /**
     * @Description: 查看用户名和密码是否正确
     * @Author: li
     * @Create: 2019/7/24-9:46
     * @param admin
     * @Return boolean true:正确
     */
    boolean queryAdmin(Admin admin);
}
