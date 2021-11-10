/**
 * 
 */
package com.preeti.animals.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.preeti.animals.common.SqlConstants;
import com.preeti.animals.dao.AnimalDAO;
import com.preeti.animals.entity.Animal;
import com.preeti.animals.entity.AnimalType;
import com.preeti.animals.entity.MoveType;

/**
 * Dao Impl class for handling DB CRUD interaction for Animal entity
 * 
 */
@Repository
public class AnimalDaoImpl implements AnimalDAO {

	Logger logger = LoggerFactory.getLogger(AnimalDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Animal save(Animal animal) {
		jdbcTemplate.update(SqlConstants.INSERT_ANIMAL, animal.getName(), animal.getAnimalType().getId(),
				animal.getMoveType().getId());
		return animal;

	}

	@Override
	public List<Animal> getAllAnimals() {
		List<Animal> result = jdbcTemplate.query(SqlConstants.FIND_ALL_ANIMALS, this::mapRowToAnimal);
		return result;
	}

	private Animal mapRowToAnimal(ResultSet resultSet, int rowNum) throws SQLException {
		return Animal.builder().id(resultSet.getString(SqlConstants.ID)).name(resultSet.getString(SqlConstants.NAME))
				.moveType(MoveType.builder().moveType(resultSet.getString(SqlConstants.MOVE_TYPE)).build())
				.animalType(AnimalType.builder().animalType(resultSet.getString(SqlConstants.ANIMAL_TYPE)).build())
				.build();
	}

	@Override
	public Animal getAnimalByName(String name) {
		List<Animal> animal = jdbcTemplate.query(SqlConstants.FIND_ANIMAL_BY_NAME, new Object[] { name },
				this::mapRowToAnimal);
		return animal.isEmpty() ? null : animal.get(0);
	}

	@Override
	public void deleteAnimal(String name) {
		jdbcTemplate.update(SqlConstants.DELETE_ANIMAL_BY_NAME, name);
	}
}
