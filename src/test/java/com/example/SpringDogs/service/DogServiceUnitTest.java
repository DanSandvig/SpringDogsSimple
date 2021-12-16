package com.example.SpringDogs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.SpringDogs.domain.Dog;
import com.example.SpringDogs.repo.DogRepo;

@SpringBootTest
public class DogServiceUnitTest {
	
	//Autowiring mocks into the service class
	@Autowired
	private DogService service;
	
	//we are mocking the repository class as we dont want to directly depend on the repo class itself
	@MockBean
	private DogRepo repo;
	
	@Test
	public void createTest() {
		Dog input = new Dog("Doggo", "Pitbull", 3);
		Dog output = new Dog(1L, "Doggo", "Pitbull", 3);
		
		//Here we are testing the actual method (within the create method from DogService)
		Mockito.when(this.repo.save(input)).thenReturn(output);
		
		//Here we are checking the expected value (output) is the same as the actual value (method itself)
		assertEquals(output, this.service.create(input));
		
		//Verifies that repo is run 1 time, and that it saves the input
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}
	
	
	
}
