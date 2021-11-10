package com.preeti.animals.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.preeti.animals.common.CachingConstansts;
import com.preeti.animals.entity.AnimalType;
import com.preeti.animals.repository.AnimalTypeRepository;
import com.preeti.animals.service.AnimalTypeService;

/**
 * Service class for handling business logic for AnimalType entity
 * 
 */
@Service
public class AnimalTypeServiceImpl implements AnimalTypeService {

	@Autowired
	AnimalTypeRepository animalTypeRepo;

	@Override
	public AnimalType findAnimalTypeByName(String name) {
		List<AnimalType> list = findAnimalTypes();
		return list.stream().filter(a -> a.getAnimalType().equals(name)).findFirst().get();
	}

	@Override
	@Cacheable(CachingConstansts.ANIMAL_TYPES)
	public List<AnimalType> findAnimalTypes() {
		return (List<AnimalType>) animalTypeRepo.findAll();

	}

}
