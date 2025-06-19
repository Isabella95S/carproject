package com.develhope.carproject.models;

import com.develhope.carproject.enums.Color;
import com.develhope.carproject.enums.Type;
import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40, nullable = false)
    private String modelName;

    @Column(length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(length = 250, nullable = true)
    private String description;

}
