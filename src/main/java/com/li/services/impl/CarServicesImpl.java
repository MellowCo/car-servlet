package com.li.services.impl;

import com.li.dao.ICarDao;
import com.li.dao.impl.CarDaoImpl;
import com.li.domain.Car;
import com.li.domain.PageBean;
import com.li.services.ICarServices;

import java.util.List;
import java.util.Map;

/**
 * @Program: exam
 * @ClassName: CarServicesImpl
 * @Description:
 * @Author: li
 * @Create: 2019-07-24 13:52
 */
public class CarServicesImpl implements ICarServices {
    ICarDao dao = new CarDaoImpl();

    //将车辆进行排序
    //1:按租金升序，0:按车名排序,-1:按租金降序
    @Override
    public List<Car> sortCars(int status) {
        if(status == 1){
            return dao.queryAllCarByRentAsc();
        }else if (status == 0){
            return dao.queryAllCar();
        }else {
            return dao.queryAllCarByRentDesc();
        }
    }

    @Override
    public List<Car> fuzzyQueryByCar(String name) {
        return dao.fuzzyQueryByCar(name);
    }

    @Override
    public Car queryCarById(int id) {
        return dao.queryCarById(id);
    }

    @Override
    public PageBean<Car> pageCar(String _pageStart, String _pageSize, Map<String, String[]> map) {
        int pageStart = Integer.parseInt(_pageStart);
        int pageSize = Integer.parseInt(_pageSize);

        List<Car> cars = dao.pageCar((pageStart - 1) * pageSize, pageSize, map);
        int totalData = dao.totalData(map);
        return new PageBean<Car>(pageStart, pageSize, totalData, cars);
    }

    @Override
    public void changCarDown(int cid) {
        dao.changCarDown(cid);
    }

    @Override
    public void addCar(Car car) {
        dao.addCar(car);
    }

    @Override
    public void changeCarStatus(int id, int status) {
        dao.changeCarStatus(id,status);
    }


}
