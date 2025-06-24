package com.develhope.carproject.controller;


import com.develhope.carproject.models.Car;
import com.develhope.carproject.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @GetMapping
    public List<Car> carList(){

        return carRepository.findAll();
    }
    @PostMapping("/create")
    public Car createCar(@RequestBody Car car){  //creazione di un'auto
        return carRepository.save(car);
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable Integer id){  //ricerca dell'auto tramite l'id
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        return optionalCar.get();
    }

//    @GetMapping("/{id}")
//    public Car findById(@PathVariable Integer id){
//        if (!carRepository.existsById(id)){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auto con id " + id + " non trovata");
//        }
//        return carRepository.findById(id).get();
//    }
//    @PostMapping("/updateType/{id}")
    public Car updateType(@PathVariable Integer id,@RequestBody Car carInput){  //versione del metodo più conveniente, poiché scrivo meno codice e faccio due cose in una
        Optional<Car> optionalCar = carRepository.findById(id);
        if(optionalCar.isPresent()){
            Car risultato = optionalCar.get();
            risultato.setType(carInput.getType());

            return carRepository.save(risultato);

        }else{
            throw  new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
    }

//    @PostMapping("/updateType/{id}")
//    public Car updateType(@PathVariable Integer id, @RequestBody Car carInput){
//        if (!carRepository.existsById(id)){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auto con id " + id + " non trovata");
//
//        }
//        Car car = carRepository.findById(id).get();
//        car.setType(carInput.getType());
//        return carRepository.save(car);
//    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        if(carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return " OK";
        }else{
            throw  new ResponseStatusException(HttpStatusCode.valueOf(404), "Id non valido, auto non trovata ");
        }
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
    carRepository.deleteAll();
    return " OK";
    }

//    public List<Car> carList findAll(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
//                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
//
//        if (pageNumber < 0) {
//
//    }
}
