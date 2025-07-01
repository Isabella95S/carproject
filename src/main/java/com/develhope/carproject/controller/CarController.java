package com.develhope.carproject.controller;


import com.develhope.carproject.dto.APIResponse;
import com.develhope.carproject.models.Car;
import com.develhope.carproject.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarRepository carRepository;

//    @GetMapping
//    public List<Car> carList(){
//
//        return carRepository.findAll();
//    }
    @PostMapping("/create")
    public ResponseEntity<Car> createCar(@RequestBody Car car){  //creazione di un'auto
        return ResponseEntity.ok(carRepository.save(car));
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable Integer id){  //ricerca dell'auto tramite l'id
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isEmpty()){
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        return optionalCar.get();
    }

//    @GetMapping("/paginated")
//    public  List<Car>
//    @GetMapping("/{id}")
//    public Car findById(@PathVariable Integer id){
//        if (!carRepository.existsById(id)){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auto con id " + id + " non trovata");
//        }
//        return carRepository.findById(id).get();
//    }
@PostMapping("/updateType/{id}")
public Car updateType(@PathVariable Integer id,@RequestBody Car carInput){  //versione del metodo più conveniente, poiché scrivo meno codice e faccio due cose in una
    Optional<Car> optionalCar = carRepository.findById(id);
    if(optionalCar.isPresent()){
        Car risultato = optionalCar.get();
        risultato.setCarType(carInput.getCarType());

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
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (!carRepository.existsById(id)) {
            return ResponseEntity.notFound().build();

        }
        carRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAll(){
        carRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/paginated")
    public Page<Car> getCars(@RequestParam String modelName, @RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        if(!modelName.isBlank()){
            Page<Car> carList = carRepository.findByModelNameContaining(modelName, PageRequest.of(pageNumber,pageSize));
            return carList;
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/search")
    public ResponseEntity<Page<Car>> searchByType(@RequestParam String carType,
                                                    @RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                                                    @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                    @RequestParam(required = false, defaultValue = "ASC") String sortDir){
        Sort sort = sortDir.equalsIgnoreCase("DESC") ? Sort.by("carType").descending()
                : Sort.by("carType").ascending();

        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);
        Page<Car> car = carRepository.findByTypeContainsIgnoreCase( carType + "%", pageable );  //

        return ResponseEntity.ok(car);
    }

}
