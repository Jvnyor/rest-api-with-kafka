package br.com.josias.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.josias.kafka.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	
}
