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
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.preeti.animals.common.APIConstants;
import com.preeti.animals.dto.AnimalDTO;
import com.preeti.animals.service.AnimalService;

@RunWith(MockitoJUnitRunner.class)
public class AnimalControllerTest {

	@Mock
	private AnimalService animalService;

	@Autowired
	private TestRestTemplate restTemplate;

	List<AnimalDTO> allAnimals;
	private String url;

	@Before
	public void setUp() throws Exception {
		AnimalDTO cow = new AnimalDTO("crow", "Bird", "Fly");
		AnimalDTO whale = new AnimalDTO("whale", "Fish", "Swim");
		allAnimals = Arrays.asList(cow, whale);
		url = "localhost:8080" + APIConstants.BASE_PATH;
	}

	@Test
	public void testGetAnimals() throws Exception {
		when(animalService.getAnimals()).thenReturn(allAnimals);
		ResponseEntity<AnimalDTO[]> response = this.restTemplate.getForEntity(url, AnimalDTO[].class);
		assertArrayEquals(allAnimals.toArray(), response.getBody());
	}

	@Test
	public void testCreateAnimals() throws Exception {		
		when(animalService.createAnimal(allAnimals.get(0))).thenReturn(allAnimals.get(0));
		ResponseEntity<AnimalDTO> response = this.restTemplate.postForEntity(url, allAnimals.get(0), AnimalDTO.class);
		assertEquals(allAnimals.get(0), response.getBody());
	}

	@Test
	public void testDeleteAnimal() throws Exception {
		ResponseEntity<Void> resp = this.restTemplate.exchange(url + "/cow", HttpMethod.DELETE, HttpEntity.EMPTY,
				Void.class);
		assertEquals(HttpStatus.NO_CONTENT, resp.getStatusCode());
	}
}
