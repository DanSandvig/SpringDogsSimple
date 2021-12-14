package com.example.SpringDogs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.SpringDogs.domain.Dog;
import com.example.SpringDogs.repo.DogRepo;

@Service
public class DogService implements ServiceMethods<Dog>{
	
	//NOT making a new object, creating a variable of the type DogRepo
	private DogRepo repo;
	
	//Above is different to this, as we are trying to instantiate an object below (We cant do this to an interface)
//	DogRepo repos = new DogRepo();
	
	
	//Constructor
	public DogService(DogRepo repo) {
		this.repo = repo;
	}
	
	
	@Override
	public Dog create(Dog dog) {
		return this.repo.save(dog);
	}

	@Override
	public List<Dog> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Dog getById(long id) {
		Optional<Dog> optionalDog = this.repo.findById(id);
		if(optionalDog.isPresent()) {
			return optionalDog.get();
		}
		return null;
	}

	@Override
	public Dog update(long id, Dog dog) {
		Optional<Dog> existingDog = this.repo.findById(id);
		if(existingDog.isPresent()) {
			Dog existing = existingDog.get();
			existing.setAge(dog.getAge());
			existing.setName(dog.getName());
			existing.setBreed(dog.getBreed());
			
			return this.repo.saveAndFlush(existing);
		}
		
		return null;
	}
	
//Deletes the ID, and checks the ID has actually been deleted (Returns true)
	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
