package com.preeti.animals.common;

import org.mapstruct.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.preeti.animals.dto.AnimalDTO;
import com.preeti.animals.entity.Animal;
import com.preeti.animals.service.AnimalTypeService;
import com.preeti.animals.service.MoveTypeService;

@Component
public class AnimalTrans {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	AnimalTypeService animalTypeService;

	@Autowired
	MoveTypeService moveTypeService;

	public Animal dtoToEntity(AnimalDTO animalDTO) {
		Animal animal = modelMapper.map(animalDTO, Animal.class);
		animal.setAnimalType(animalTypeService.findAnimalTypeByName(animalDTO.getAnimalType()));
		animal.setMoveType(moveTypeService.findMoveTypeByName(animalDTO.getMoveType()));
		return animal;
	}

	@Mapping(target = "animalType", source = "animalType.animalType")
	@Mapping(target = "moveType", source = "moveType.moveType")
	public AnimalDTO entityToDto(Animal animal) {
		return modelMapper.map(animal, AnimalDTO.class);
	}

}
