package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy="personId")
    Set<Vehicle> vehicle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Vehicle> getVehicles() {
        return vehicle;
    }

    public void setVehicle(Set<Vehicle> vehicles) {
        this.vehicle = vehicles;
    }
}
