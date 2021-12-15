package com.example.SpringDogs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringDogs.domain.Dog;
import com.example.SpringDogs.service.DogService;

@RestController
@RequestMapping("/dog")
public class DogController {

	private DogService service;
	
	private DogController(DogService service) {
		this.service = service;
	}
	
	//Create
	@PostMapping("/create")
	public ResponseEntity<Dog> createDog(@RequestBody Dog dog) {
		return new ResponseEntity<Dog>(this.service.create(dog), HttpStatus.CREATED);
	}
	
	//Read All
	@GetMapping("/readAll")
	public ResponseEntity<List<Dog>> readAllDogs(){
		return new ResponseEntity<List<Dog>>(this.service.getAll(), HttpStatus.OK);
	}
	
	//Read By Id
	@GetMapping("/readById/{id}")
	public ResponseEntity<Dog> readDogById(@PathVariable long id){
		return new ResponseEntity<Dog>(this.service.getById(id), HttpStatus.OK);
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Dog> updateDog(@PathVariable long id, @RequestBody Dog dog){
		return new ResponseEntity<Dog>(this.service.update(id, dog), HttpStatus.ACCEPTED);
	}
	
	//Delete					
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteDog(@PathVariable long id){
		//Line below uses a Ternary Operator, basically says IF service.delete method goes through, RETURN no content ELSE return not found
		return (this.service.delete(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) : 
			new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}
	
}
