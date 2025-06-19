package com.develhope.carproject.controller;


import com.develhope.carproject.models.Car;
import com.develhope.carproject.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarRepository carRepository;

//    public Page<Car> findAll(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
//                             @RequestParam(required = false, defaultValue = "10") Integer pageSize){
//
//    }
//    Pageable pageable = PageRequest.of(pageNumber, pageSize);
//    return carRepository.findAll(pageble);


}
