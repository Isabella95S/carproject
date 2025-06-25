package com.develhope.carproject.repository;

import com.develhope.carproject.models.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    List<Car>findByModelNameContaining(String modelName, Pageable pageable);
    //List<Car>findByType(Type carType);


}
