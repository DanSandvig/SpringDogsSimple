package com.example.SpringDogs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SpringDogs.domain.Dog;

@Service
public class DogService implements ServiceMethods<Dog>{

	@Override
	public Dog create(Dog t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dog> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dog getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dog update(long id, Dog t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
