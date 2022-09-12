package web.hiber.dao;

import web.hiber.model.Car;

import java.util.List;


public interface CarDao {

    void add(Car car);

    List<Car> getCarList(int count);
}
