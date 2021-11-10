/**
 * 
 */
package com.preeti.animals.service;

import java.util.List;

import com.preeti.animals.dto.AnimalDTO;
import com.preeti.animals.exception.DuplicateAnimalException;

public interface AnimalService {

	AnimalDTO createAnimal(AnimalDTO animalDTO) throws DuplicateAnimalException ;
	
	List<AnimalDTO> getAnimals();

	void deleteAnimal(String name);	

}
