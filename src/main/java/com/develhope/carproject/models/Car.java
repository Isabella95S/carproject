package com.develhope.carproject.models;

import com.develhope.carproject.enums.CarType;
import com.develhope.carproject.enums.Color;
;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Integer id;

    @Column(name = "model_name",length = 40, nullable = false)
    @NotNull
    private String modelName;

    @Column(length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private CarType carType;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(name= "descr",length = 2500, nullable = true)
    private String description;

    public Car(String modelName, CarType type, Color color, String description) {

        this.modelName = modelName;
        this.carType = type;
        this.color = color;
        this.description = description;
    }

    public Car( String modelName, CarType carType, Color color) {
        this(modelName,carType,color, null);
    }

    private Car(){ //per far costruire gli oggetti a JPA

    }
    public Color getColor() {
        return color;
    }


    public CarType getCarType() {
        return carType;
    }

    public Integer getId() {
        return id;
    }

    public String getModelName() {
        return modelName;
    }

    public String getDescription() {
        return description;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }


    public void setColor(Color color) {
        this.color = color;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
