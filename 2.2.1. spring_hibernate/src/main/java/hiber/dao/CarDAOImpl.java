package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDAOImpl implements CarDAO {
    private final SessionFactory sessionFactory;

    public CarDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
    sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public Car getCarByModelSeries(String model, int series) {

        return (Car) sessionFactory.getCurrentSession().createQuery("from Car where model = :model and series = :series")
                .setParameter("model", model)
                .setParameter("series", series)
                .getSingleResult();
    }
    public Car getCarById(long id) {
        return  sessionFactory.getCurrentSession().get(Car.class, id);
    }
}
