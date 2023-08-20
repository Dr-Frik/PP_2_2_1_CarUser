package hiber.service;

import hiber.model.Car;

public interface CarService {
    void addCar(Car car);

    Car getCarByModelSeries(String model, int series);

    Car getCarById(long id);
}
