package uz.pdp.carrequest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.carrequest.entity.Car;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final RestTemplate restTemplate;

    public List getAllCars() {
        return restTemplate.getForObject("http://localhost:8082/cars", List.class);
    }

    public Car getCarById(String id) {
        return restTemplate.getForObject("http://localhost:8082/cars/" + id, Car.class);
    }

    public Car createCar(Car car) {
        return restTemplate.postForObject("http://localhost:8082/cars", car, Car.class);
    }

    public Car updateCar(String id, Car car) {
        restTemplate.put("http://localhost:8082/cars/" + id, car);
        return car;
    }


    public void deleceById(String id) {
        restTemplate.delete("http://localhost:8082/cars/" + id);
    }
}
