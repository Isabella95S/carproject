package com.develhope.carproject.repository;

import com.develhope.carproject.models.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    Page<Car> findByModelNameContaining(String modelName, Pageable pageable);

    Page<Car> findByTypeContains(String carType, Pageable pageable );



}
