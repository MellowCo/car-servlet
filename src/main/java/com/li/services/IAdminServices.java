package com.li.services;

import com.li.domain.Admin;

/**
 * @Program: exam
 * @ClassName: IAdminServices
 * @Description:
 * @Author: li
 * @Create: 2019-07-24 09:51
 */
public interface IAdminServices {
    /**
     * @Description: 管理员登陆
     * @Author: li
     * @Create: 2019/7/24-9:51
     * @param admin
     * @Return int 1:帐号密码争取 0:帐号不存在 -1:密码错误
     */
    int Login(Admin admin);
}
