package com.preeti.animalservice;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.preeti.animals.common.APIConstants;
import com.preeti.animals.dao.AnimalDAO;
import com.preeti.animals.dto.AnimalDTO;
import com.preeti.animals.entity.Animal;
import com.preeti.animals.entity.AnimalType;
import com.preeti.animals.entity.MoveType;
import com.preeti.animals.service.AnimalService;

@RunWith(MockitoJUnitRunner.class)
public class AnimalServiceTest {

	@Mock
	private AnimalDAO animalDao;

	@Autowired
	private AnimalService animalservice;;

	List<Animal> allAnimals;

	AnimalDTO animalDto;

	Animal animal;

	@Before
	public void setUp() throws Exception {
		Animal cow = new Animal("1", "crow", new AnimalType(1, "Bird"), new MoveType(1, "Fly"));
		Animal whale = new Animal("2", "whale", new AnimalType(1, "Fish"), new MoveType(1, "Swim"));
		allAnimals = Arrays.asList(cow, whale);
		animalDto = new AnimalDTO("whale", "Fish", "Swim");
		animal = new Animal("2", "whale", new AnimalType(1, "Fish"), new MoveType(1, "Swim"));
	}

	@Test
	public void testGetAnimals() throws Exception {
		when(animalDao.getAllAnimals()).thenReturn(allAnimals);
		List<AnimalDTO> response = this.animalservice.getAnimals();
		assertEquals(response.size(), allAnimals.size());
	}

	@Test
	public void testCreateAnimal() throws Exception {
		when(animalDao.save(animal)).thenReturn(animal);
		AnimalDTO response = this.animalservice.createAnimal(animalDto);
		assertEquals(response.getName(), animalDto.getName());
	}

}
