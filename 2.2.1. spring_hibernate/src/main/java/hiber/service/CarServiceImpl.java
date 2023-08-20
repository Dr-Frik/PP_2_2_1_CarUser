package hiber.service;

import hiber.dao.CarDAO;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDAO carDAO;
    @Transactional
    @Override
    public void addCar(Car car) {
        carDAO.add(car);
    }
    @Transactional
    @Override
    public Car getCarByModelSeries(String model, int series) {
        return carDAO.getCarByModelSeries(model, series);
    }

    @Override
    @Transactional
    public Car getCarById(long id) {
        return carDAO.getCarById(id);
    }
}
