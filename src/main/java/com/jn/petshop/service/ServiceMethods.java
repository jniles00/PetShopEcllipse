package com.jn.petshop.service;

import java.util.List;

public interface ServiceMethods<T> {
	
	// Create
	T create (T PetEntity);
	
	// Read all
	List<T> readAll();
	
	// Read by ID
	T readById(Long id);
	
	// Updated
	T update(Long id, T PetEntity);
	
	// Delete
	boolean delete(Long id);
}