package com.example.demo.repo;

import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAll();

    @Query("SELECT p FROM Person p WHERE p.name LIKE :partialName")
    List<Person> getByPartialName(@Param("partialName") String partialName);

    Person save(@Param("person") Person person);
}
