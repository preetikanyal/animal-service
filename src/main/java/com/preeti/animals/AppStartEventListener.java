package com.preeti.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.preeti.animals.service.AnimalService;
import com.preeti.animals.service.AnimalTypeService;
import com.preeti.animals.service.MoveTypeService;

/**
 * class to load animal, animalType and moveType data at application startup
 * 
 */
@Component
public class AppStartEventListener {
	@Autowired
	AnimalService animalService;
	@Autowired
	AnimalTypeService animalTypeService;
	@Autowired
	MoveTypeService moveTypeService;

	@EventListener
	public void onApplicationReady(ApplicationReadyEvent ready) {
		animalService.getAnimals();
		moveTypeService.findMoveTypes();
		animalTypeService.findAnimalTypes();
	}
}
