package com.li.dao;

import com.li.domain.Car;

import java.util.List;
import java.util.Map;

/**
 * @Program: exam
 * @ClassName: ICarDao
 * @Description:
 * @Author: li
 * @Create: 2019-07-24 13:11
 */
public interface ICarDao {
    /**
     * @Description: 返回所有的车辆信息,按车名排序
     * @Author: li
     * @Create: 2019/7/24-13:36
     * @param
     * @Return java.util.List<com.li.domain.Car>
     */
    List<Car> queryAllCar();

    /**
     * @Description: 按租金倒序
     * @Author: li
     * @Create: 2019/7/24-13:36
     * @param
     * @Return java.util.List<com.li.domain.Car>
     */
    List<Car> queryAllCarByRentDesc();

    /**
     * @Description: 按租金升序
     * @Author: li
     * @Create: 2019/7/24-13:36
     * @param
     * @Return java.util.List<com.li.domain.Car>
     */
    List<Car> queryAllCarByRentAsc();

    /**
     * @Description: 根据车名模糊查询
     * @Author: li
     * @Create: 2019/7/24-14:18
     * @param name
     * @Return java.util.List<com.li.domain.Car>
     */
    List<Car> fuzzyQueryByCar(String name);

    /**
     * @Description: 根据车辆id 返回 car
     * @Author: li
     * @Create: 2019/7/24-15:47
     * @param id
     * @Return com.li.domain.Car
     */
    Car queryCarById(int id);

    /**
     * @Description: 更改车辆状态
     * @Author: li
     * @Create: 2019/7/24-16:22
     * @param id
     * @param status
     * @Return void
     */
    void changeCarStatus(int id , int status);

    /**
     * @Description: 分页加模糊查询,返回car
     * @Author: li
     * @Create: 2019/7/24-19:58
     * @param pageStart
     * @param pageSize
     * @param map
     * @Return java.util.List<com.li.domain.Car>
     */
    List<Car> pageCar(int pageStart, int pageSize, Map<String, String[]> map);

    /**
     * @Description: 返回模糊查询的数据总数
     * @Author: li
     * @Create: 2019/7/23-20:57
     * @param map
     * @Return int
     */
    int totalData(Map<String, String[]> map);

    /**
     * @Description: 下架
     * @Author: li
     * @Create: 2019/7/24-20:57
     * @param cid
     * @Return void
     */
    void changCarDown(int cid);

    /**
     * @Description: 添加新车
     * @Author: li
     * @Create: 2019/7/24-21:24
     * @param car
     * @Return void
     */
    void addCar(Car car);

    /**
     * @Description: 返回车总数
     * @Author: li
     * @Create: 2019/7/25-15:26
     * @param
     * @Return int
     */
    int totalCar();


}
