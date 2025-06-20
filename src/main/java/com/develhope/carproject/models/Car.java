package com.develhope.carproject.models;

import com.develhope.carproject.enums.Color;
import com.develhope.carproject.enums.Type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Car(String modelName, Type type, Color color, String description) {

        this.modelName = modelName;
        this.type = type;
        this.color = color;
        this.description = description;
    }

    public Car( String modelName, Type type, Color color) {
        this(modelName,type,color, null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(name= "descr",length = 2500, nullable = true)
    private String description;

}
