package quru.qa.repo;

import quru.qa.domain.Car;
import quru.qa.domain.BMW;
import quru.qa.domain.Mercedes;

import java.util.Map;

public class CarStore {

    private final Map<String, Car> store = Map.of(
            "BMW", new BMW(),
            "Mercedes", new Mercedes()
    );

    public String[] getCarName() {
        return store.keySet().toArray(String[]::new);
    }

    public Car lookup(String carName) {
        for (String key : store.keySet()) {
            if (key.equalsIgnoreCase(carName)) {
                return store.get(key);
            }
        }
        throw new IllegalArgumentException("Car not found for given argument: " + carName);
    }
}
