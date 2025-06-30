package com.develhope.carproject.repository;

import com.develhope.carproject.models.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    Page<Car> findByModelNameContaining(String modelName, Pageable pageable);

    @Query(value= "SELECT c FROM Car c WHERE CONCAT('',c.carType) LIKE ?1 ")
    Page<Car> findByTypeContainsIgnoreCase(String carType, Pageable pageable );



}
