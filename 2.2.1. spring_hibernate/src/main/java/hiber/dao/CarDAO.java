package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

public interface CarDAO {
    void add(Car car);

    //User getUserByModelSeries(String model, int series);
    Car getCarByModelSeries(String model, int series);

    Car getCarById(long id);
}

