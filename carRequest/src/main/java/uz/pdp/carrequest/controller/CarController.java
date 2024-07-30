package uz.pdp.carrequest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.carrequest.entity.Car;
import uz.pdp.carrequest.service.CarService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {


    private final CarService carService;

    @GetMapping
    public List<Car> getCar() {
        return carService.getAllCars();
    }

    @GetMapping("{id}")
    public Car getCarById(@PathVariable String id) {
        return carService.getCarById(id);
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }

    @PutMapping("{id}")
    public Car updateCar(@PathVariable String id, @RequestBody Car car) {
        return carService.updateCar(id, car);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable String id) {
        carService.deleceById(id);
    }
}
