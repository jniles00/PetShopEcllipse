package com.jn.petshop.pet;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class PetEntity {
	//Auto generates ID and puts it into ID column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// Name has to be a String and unique
	@Column(unique = true, nullable = false)
	private String name;
	
	@Column
	private String breed;
	
	@Column
	private String colour;
	
	@Column
	private String type;

	// Default Constructor
	public PetEntity() {}
	
	// Constructor with no ID
	public PetEntity(String name, String breed, String colour, String type) {
		this.name = name;
		this.breed = breed;
		this.colour = colour;
		this.type = type;
	}
	
	// Constructor with ID
	public PetEntity(long id, String name, String breed, String colour, String type) {
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.colour = colour;
		this.type = type;
	}
	
	// Getters and Setters
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	// End of Getters and Setters

	@Override
	public String toString() {
		return "\n"
				+ "PetEntity ID: " + id + "\n"
				+ "Name: " + name + "\n"
				+ "Breed: " + breed + "\n"
				+ "Colour: " + colour + "\n"
				+ "Type: " + type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(breed, colour, id, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PetEntity other = (PetEntity) obj;
		return Objects.equals(breed, other.breed) && Objects.equals(colour, other.colour) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}
}