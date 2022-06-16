package com.Jvnyor.kafka.producer.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Jvnyor.kafka.model.Car;
import com.Jvnyor.kafka.model.dto.CarDTO;
import com.Jvnyor.kafka.producer.producer.CarProducer;
import com.Jvnyor.kafka.repository.CarRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(value = "Kafka resources")
@CrossOrigin("*")
@Slf4j
public class CarController {
	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CarProducer carProducer;

	@PostMapping("/cars")
	@ApiOperation(value = "Send model and color of the car to kafka, and database")
	public ResponseEntity<CarDTO> create(@RequestBody CarDTO carDTO, Car carAdd) {
		CarDTO car = CarDTO.builder()
				.id(UUID.randomUUID().toString())
				.color(carDTO.getColor())
				.model(carDTO.getModel())
				.build();
		carProducer.send(car);
		save(carDTO);
		log.info("carDTO: {}", carDTO.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(car);
	}

	public Car save(@RequestBody CarDTO carDTO) {
		return carRepository.save(Car.builder()
				.model(carDTO.getModel())
				.color(carDTO.getColor())
				.build());
	}

	@GetMapping("/cars/list")
	@ApiOperation(value = "List of cars")
	public List<Car> listAll() {
		return carRepository.findAll();
	}
}
