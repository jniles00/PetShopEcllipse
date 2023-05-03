package com.jn.petshop.service;

import java.util.*;

import com.jn.petshop.pet.PetEntity;
import com.jn.petshop.repo.PetShopRepo;

public class PetShopService implements ServiceMethods<PetEntity>{
	
	// Create a PetShop Repo variable
	private PetShopRepo repo;
	
	public PetShopService(PetShopRepo repo) {
		this.repo = repo;
	}

	// Create a new Pet object
	@Override
	public PetEntity create(PetEntity PetEntity) {
		return this.repo.save(PetEntity);
	}

	// Display all Pet objects
	@Override
	public List<PetEntity> readAll(){
		return this.repo.findAll();
	}
	
	// Display Pet object by ID
	public PetEntity readById(Long id) {
		Optional<PetEntity> getPetEntity = this.repo.findById(id);
		
		// If the ID is present then it will display the pet's information
		if(getPetEntity.isPresent()) {
			return getPetEntity.get();
		}
		return null;
	}
	
	// Find a pet by it's ID and updates it's information by using the getters
	// and setters
	@Override
	public PetEntity update(Long id, PetEntity PetEntity) {
		Optional<PetEntity> updatingPet = this.repo.findById(id);
		
		// If the pet exists then the information can be updated
		if(updatingPet.isPresent()) {
			PetEntity update = updatingPet.get();
			update.setName(PetEntity.getName());
			update.setBreed(PetEntity.getBreed());
			update.setColour(PetEntity.getColour());
			update.setType(PetEntity.getType());
			
			// Saves the changes and then flushes the buffer
			return this.repo.saveAndFlush(update);
		}
		return null;
	}
	
	// Delete PetEntity object by ID and checks to see if it still exists
	// If it returns true then it has been deleted successfully
	@Override
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return false;
	}
}