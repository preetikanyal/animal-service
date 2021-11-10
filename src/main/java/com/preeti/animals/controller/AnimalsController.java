package com.preeti.animals.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.preeti.animals.common.APIConstants;
import com.preeti.animals.dto.AnimalDTO;
import com.preeti.animals.exception.AnimalNotFoundException;
import com.preeti.animals.exception.DuplicateAnimalException;
import com.preeti.animals.service.AnimalService;

/**
 * RestController for exposing REST end points for animal entity
 * 
 */
@RestController
@RequestMapping(APIConstants.BASE_PATH)
public class AnimalsController {

	@Autowired
	AnimalService animalService;
	Logger logger = LoggerFactory.getLogger(AnimalsController.class);

	@GetMapping
	public ResponseEntity<List<AnimalDTO>> getAnimals() {
		logger.debug("Getting list of all the animals");
		List<AnimalDTO> list = animalService.getAnimals();
		return ResponseEntity.ok(list);
	}

	@PostMapping
	public ResponseEntity<AnimalDTO> createAnimal(@Valid @RequestBody Optional<AnimalDTO> animalDto)
			throws DuplicateAnimalException {
		logger.debug("Creating animal with data: ", animalDto);
		AnimalDTO resultDTO = null;
		resultDTO = animalService.createAnimal(animalDto.get());
		logger.debug("Animal with data: ", animalDto, " created successfully");
		return new ResponseEntity<>(resultDTO, HttpStatus.OK);
	}

	@RequestMapping(value = APIConstants.NAME, method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAnimal(@PathVariable Optional<String> name) throws AnimalNotFoundException {
		logger.debug("Delete animal with name: ", name);
		animalService.deleteAnimal(name.get());
		logger.debug("Animal with name: ", name, " deleted successfully.");
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
