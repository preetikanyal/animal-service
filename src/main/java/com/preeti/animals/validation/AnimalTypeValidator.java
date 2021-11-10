package com.preeti.animals.validation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.preeti.animals.entity.AnimalType;
import com.preeti.animals.service.AnimalTypeService;

/**
 * This class validates the AnimalType data
 * 
 */
public class AnimalTypeValidator implements ConstraintValidator<AnimalTypeConstraint, String> {

	@Autowired
	AnimalTypeService animalTypeService;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {		
		List<AnimalType> animals = animalTypeService.findAnimalTypes();
		return (animals.stream().filter(o -> o.getAnimalType().equals(value)).findFirst().isPresent());
	}

	
}
