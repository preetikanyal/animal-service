/**
 * 
 */
package com.preeti.animals.service;

import java.util.List;
import com.preeti.animals.entity.AnimalType;

public interface AnimalTypeService {

	AnimalType findAnimalTypeByName(String name);

	List<AnimalType> findAnimalTypes();

}
