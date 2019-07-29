package com.li.dao;

import com.li.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @Program: exam
 * @ClassName: IUserDao
 * @Description: User dao层接口
 * @Author: li
 * @Create: 2019-07-23 09:14
 */
public interface IUserDao {
    /**
     *功能描述 查询数据库中的所有用户
     * @author li
     * @date 2019/7/23
     * @param
     * @return java.util.List<com.li.domain.User>
     */
    List<User> queryAllUser();

    /**
     *功能描述 添加用户
     * @author li
     * @date 2019/7/23
     * @param user
     * @return void
     */
    void addUser(User user);

    /**
     *功能描述 查看email是否被用
     * @author li
     * @date 2019/7/23
     * @param email
     * @return java.lang.Boolean true:邮箱可用，false:邮箱不可有
     */
    boolean checkEmail(String email);

    /**
     * @Description: 查看用户名和密码是否正确
     * @Author: li
     * @Create: 2019/7/24-9:46
     * @param User
     * @Return boolean true:正确
     */
    boolean queryUser(User user);

    /**
     *功能描述 根据email，更改用户信息
     * @author li
     * @date 2019/7/23
     * @param email
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
     *功能描述 更改用户密码
     * @author li
     * @date 2019/7/23
     * @param user
     * @return void
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
     * @Description: 分页加模糊查询,返回用户
     * @Author: li
     * @Create: 2019/7/23-20:47
     * @param map
     * @Return java.util.List<com.li.domain.User>
     */
    List<User> pageUser(int pageStart,int pageSize,Map<String, String[]> map);

    /**
     * @Description: 返回模糊查询的数据总数
     * @Author: li
     * @Create: 2019/7/23-20:57
     * @param map
     * @Return int
     */
    int totalData(Map<String, String[]> map);

    /**
     * @Description: 返回数据库，数据的总条数
     * @Author: li
     * @Create: 2019/7/23-19:39
     * @param
     * @Return int
     */
    int totalData();

    /**
     * @Description: 返回黑名单的总数据数
     * @Author: li
     * @Create: 2019/7/23-20:37
     * @param
     * @Return int
     */
    int totalBlack();

    /**
     * @Description: 返回模糊查询的数据总数
     * @Author: li
     * @Create: 2019/7/23-21:13
     * @param map
     * @Return int
     */
    int totalBlack(Map<String, String[]> map);

    /**
     * @Description: 分页返回黑名单用户
     * @Author: li
     * @Create: 2019/7/23-20:19
     * @param pageStart
     * @param pageSize
     * @Return java.util.List<com.li.domain.User>
     */
    List<User> pageBlack(int pageStart, int pageSize,Map<String, String[]> map);

    /**
     * @Description: 查看用户是否被拉黑
     * @Author: li
     * @Create: 2019/7/24-10:43
     * @param email
     * @Return boolean false:拉黑
     */
    boolean queryStatus(String email);


}
