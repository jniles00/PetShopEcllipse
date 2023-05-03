package com.jn.petshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jn.petshop.pet.PetEntity;

@Repository
public interface PetShopRepo extends JpaRepository<PetEntity, Long>{

}