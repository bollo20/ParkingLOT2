package parkinglot.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import parkinglot.common.CarDto;
import parkinglot.entities.Car;
import parkinglot.entities.User;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CarsBean {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CarDto> findAllCars() {
        List<Car> cars = entityManager
                .createQuery("SELECT c FROM Car c", Car.class)
                .getResultList();

        return cars.stream()
                .map(car -> new CarDto(
                        car.getId(),
                        car.getLicensePlate(),
                        car.getParkingSpot(),
                        car.getOwner().getUsername()
                ))
                .collect(Collectors.toList());
    }

    public CarDto findById(Long carId) {
        Car car = entityManager.find(Car.class, carId);
        return new CarDto(
                car.getId(),
                car.getLicensePlate(),
                car.getParkingSpot(),
                car.getOwner().getUsername()
        );
    }

    public void createCar(String licensePlate, String parkingSpot, Long userId) {
        Car car = new Car();
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        User user = entityManager.find(User.class, userId);
        user.getCars().add(car);
        car.setOwner(user);

        entityManager.persist(car);
    }

    public void updateCar(Long carId, String licensePlate, String parkingSpot, Long userId) {
        Car car = entityManager.find(Car.class, carId);
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        User oldOwner = car.getOwner();
        if (!oldOwner.getId().equals(userId)) {
            oldOwner.getCars().remove(car);

            User newOwner = entityManager.find(User.class, userId);
            newOwner.getCars().add(car);
            car.setOwner(newOwner);
        }
    }

    public void deleteCarsByIds(List<Long> carIds) {
        for (Long carId : carIds) {
            Car car = entityManager.find(Car.class, carId);
            if (car != null) {
                entityManager.remove(car);
            }
        }
    }

    public int countFreeParkingSpots() {
        long totalCars = (long) entityManager
                .createQuery("SELECT COUNT(c) FROM Car c")
                .getSingleResult();

        return 50 - (int) totalCars; // 50 = total parking spots
    }
}