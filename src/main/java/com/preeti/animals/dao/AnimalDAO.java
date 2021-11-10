/**
 * 
 */
package com.preeti.animals.dao;

import java.util.List;

import com.preeti.animals.entity.Animal;

public interface AnimalDAO {

	Animal save(Animal animal);

	List<Animal> getAllAnimals();

	Animal getAnimalByName(String name);

	void deleteAnimal(String name);

}
