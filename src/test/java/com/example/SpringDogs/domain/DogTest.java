package com.example.SpringDogs.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class DogTest {

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Dog.class).usingGetClass().verify();
	}
	
	@Test
	public void noIdConstructor() {
		Dog dog = new Dog("FLuffy", "Lab", 6);
		
		//checks that when we create an object using our constructor, nothing is created as a null field
		assertNotNull(dog.getName());
		assertNotNull(dog.getBreed());
		assertNotNull(dog.getAge());
		
		assertEquals(dog.getName(), "FLuffy");
		assertEquals(dog.getBreed(), "Lab");
		assertEquals(dog.getAge(), 6);
	}

	@Test
	public void settersTest() {
		Dog dog = new Dog();
		
		dog.setName("lulu");
		dog.setBreed("golden retriever");
		dog.setAge(3);
		
		assertNotNull(dog.getName());
		assertNotNull(dog.getBreed());
		assertNotNull(dog.getAge());
		
		assertEquals(dog.getName(), "lulu");
		assertEquals(dog.getBreed(), "golden retriever");
		assertEquals(dog.getAge(), 3);
	}
}
