package com.Jvnyor.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jvnyor.kafka.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
