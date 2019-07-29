package com.li.services;

import com.li.domain.PageBean;
import com.li.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @Program: exam
 * @ClassName: IUserServices
 * @Description:
 * @Author: li
 * @Create: 2019-07-23 10:01
 */
public interface IUserServices {
    /**
     *功能描述 查询所有用户
     * @author li
     * @date 2019/7/23
     * @param
     * @return java.util.List<com.li.domain.User>
     */
    List<User> queryAllUser();

    /**
     *功能描述 用户注册
     * @author li
     * @date 2019/7/23
     * @param user
     * @return void
     */
    void register(User user);

    /**
     *功能描述 查看email是否被用
     * @author li
     * @date 2019/7/23
     * @param email
     * @return java.lang.Boolean true:邮箱可用，false:邮箱不可有
     */
    boolean checkEmail(String email);

    /**
     *功能描述 根据email，更改用户信息
     * @author li
     * @date 2019/7/23
     * @param user
     * @return void
     */
    void updateUserByEmail(User user);

    /**
     *功能描述 根据email，获取用户的信息
     * @author li
     * @date 2019/7/23
     * @param email
     * @return com.li.domain.User
     */
    User queryUserInfoByEmail(String email);

    /**
     *功能描述
     * @author li
     * @date 2019/7/23
     * @param user
     * @return void
     */

    /**
     * @Description: 更改用户密码
     * @Author: li
     * @Create: 2019/7/23-14:03
     * @param user
     * @Return void
     */
    void changePwdByEmail(User user);

    /**
     * @Description: 更改密码时，比对旧密码
     * @Author: li
     * @Create: 2019/7/23-14:14
     * @param user
     * @Return boolean true:密码正确,false:密码错误
     */
    boolean queryPwdByEmail(User user);

    /**
     * @Description: 根据email，删除用户
     * @Author: li
     * @Create: 2019/7/23-16:17
     * @param email
     * @Return void
     */
    void delUserByEmail(String email);

    /**
     * @Description: 更改用户的状态，拉黑，可用
     * @Author: li
     * @Create: 2019/7/23-16:26
     * @param email
     * @Return void
     */
    void changStatus(String email,Integer status);

    /**
     * @Description: 返回黑名单用户，status = -1
     * @Author: li
     * @Create: 2019/7/23-16:54
     * @param
     * @Return java.util.List<com.li.domain.User>
     */
    List<User> BlackList();

    /**
     * @Description: 分页返回用户
     * @Author: li
     * @Create: 2019/7/23-19:48
     * @param pageStart
     * @param pageSize
     * @Return com.li.domain.PageBean<com.li.domain.User>
     */
    PageBean<User> pageUser(String pageStart, String pageSize, Map<String, String[]> map);

    /**
     * @Description: 返回数据库，数据的总条数
     * @Author: li
     * @Create: 2019/7/23-19:39
     * @param
     * @Return int
     */
    int totalData();

    /**
     * @Description: 分页返回黑名单用户
     * @Author: li
     * @Create: 2019/7/23-20:19
     * @param pageStart
     * @param pageSize
     * @Return java.util.List<com.li.domain.User>
     */
    PageBean<User> pageBlack(String pageStart, String pageSize, Map<String, String[]> map);

    /**
     * @Description: 用户登录
     * @Author: li
     * @Create: 2019/7/24-10:38
     * @param user
     * @Return int 1:正确 0:用户名不存在 -1:密码错误 -2:被管理员拉黑
     */
    int userLogin(User user);
}
