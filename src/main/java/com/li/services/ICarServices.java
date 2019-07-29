package com.li.services;

import com.li.domain.Car;
import com.li.domain.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Program: exam
 * @ClassName: ICarServices
 * @Description:
 * @Author: li
 * @Create: 2019-07-24 13:49
 */
public interface ICarServices {
    /**
     * @Description: 将车辆进行排序
     * @Author: li
     * @Create: 2019/7/24-13:50
     * @param status 1:按租金升序，0:按车名排序,-1:按租金降序
     * @Return java.util.List<com.li.domain.User>
     */
    List<Car> sortCars(int status);

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
     * @Description: 分页返回car
     * @Author: li
     * @Create: 2019/7/24-20:01
     * @param pageStart
     * @param pageSize
     * @param map
     * @Return com.li.domain.PageBean<com.li.domain.Car>
     */
    PageBean<Car> pageCar(String pageStart, String pageSize, Map<String, String[]> map);

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
     * @Description: 更改车辆状态
     * @Author: li
     * @Create: 2019/7/24-16:22
     * @param id
     * @param status
     * @Return void
     */
    void changeCarStatus(int id , int status);

}
