package com.example.SpringDogs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringDogs.domain.Dog;

public interface DogRepo extends JpaRepository<Dog, Long>{

}
