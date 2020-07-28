package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.entity.Vehicle;
import com.example.demo.repo.PersonRepository;
import com.example.demo.repo.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class FunctionsController {
    PersonRepository personRepository;
    VehicleRepository vehicleRepository;

    public FunctionsController(@Autowired PersonRepository personRepository, @Autowired VehicleRepository vehicleRepository){
        this.personRepository= personRepository;
        this.vehicleRepository = vehicleRepository;
    }


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/functions/addVehicle")
    public void addVehicle(@RequestParam(name="personId") Long personId, @RequestParam(name="vehicleId") Long vehicleId) throws IllegalArgumentException{
        Optional<Person> p = personRepository.findById(personId);
        Person person = p.orElseThrow(() -> new IllegalArgumentException("Cannot find person"));
        Optional<Vehicle> v = vehicleRepository.findById(vehicleId);
        Vehicle vehicle = v.orElseThrow(() -> new IllegalArgumentException("Cannot find vehicle"));
        vehicle.setPersonId(personId);
        personRepository.save(person);
    }

    @GetMapping("/functions/partialSearch")
    @ResponseBody
    public List<Person> partialSearch(@RequestParam(name="text") String text) throws IllegalArgumentException{
        if (text==null) throw new IllegalArgumentException("Text is empty");
        return personRepository.getByPartialName("%" + text + "%");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public void handleException(IllegalArgumentException ex){
        logger.error("Error: " + ex.getMessage());
    }
}
