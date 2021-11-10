package com.preeti.animals.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.preeti.animals.common.AnimalTrans;
import com.preeti.animals.common.CachingConstansts;
import com.preeti.animals.dao.AnimalDAO;
import com.preeti.animals.dto.AnimalDTO;
import com.preeti.animals.entity.Animal;
import com.preeti.animals.exception.AnimalNotFoundException;
import com.preeti.animals.exception.DuplicateAnimalException;
import com.preeti.animals.service.AnimalService;

/**
 * Service class for handling business logic for Animal entity
 * 
 */
@Service
public class AnimalServiceImpl implements AnimalService {

	Logger logger = LoggerFactory.getLogger(AnimalServiceImpl.class);

	@Autowired
	AnimalDAO animalDao;

	@Autowired
	AnimalTrans animalTrans;

	@Override
	@CacheEvict(value = CachingConstansts.ANIMALS, allEntries = true)
	public AnimalDTO createAnimal(AnimalDTO animalDTO) throws DuplicateAnimalException {
		if (isAnimalPresent(animalDTO.getName()))
			throw new DuplicateAnimalException("Duplicate value for animal name");
		Animal resAnimal = animalDao.save(animalTrans.dtoToEntity(animalDTO));
		return animalTrans.entityToDto(resAnimal);
	}

	private boolean isAnimalPresent(String name) {
		List<Animal> list = animalDao.getAllAnimals();
		boolean res = list.stream().filter(o -> o.getName().equals(name)).findFirst()
				.isPresent();
		return res;
	}

	@Override
	@Cacheable(CachingConstansts.ANIMALS)
	public List<AnimalDTO> getAnimals() {
		List<Animal> animals = animalDao.getAllAnimals();
		List<AnimalDTO> animalDTOList = animals.stream().map(a -> animalTrans.entityToDto(a))
				.collect(Collectors.toList());
		return animalDTOList;
	}

	@Override
	@CacheEvict(value = CachingConstansts.ANIMALS,  allEntries = true)
	public void deleteAnimal(String name) {
		if (!isAnimalPresent(name))
			throw new AnimalNotFoundException("Animal with name " + name + " does not exist");
		animalDao.deleteAnimal(name);
	}
}
