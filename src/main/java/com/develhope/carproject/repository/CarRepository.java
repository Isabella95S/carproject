package com.develhope.carproject.repository;

import com.develhope.carproject.enums.Type;
import com.develhope.carproject.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    List<Car>findBymodelName(String modelName);
    List<Car>findBytype(Type type);
}
