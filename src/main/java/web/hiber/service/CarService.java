package web.hiber.service;

import web.hiber.model.Car;

import java.util.List;

public interface CarService {
    void add(Car car);


    List<Car> getCarList(int count);
}
