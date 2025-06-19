package com.develhope.carproject.repository;

import com.develhope.carproject.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {


}
