package com.preeti.animals.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.preeti.animals.entity.AnimalType;

/**
 * Repository for handling DB CRUD operations for AnimalType entity
 * 
 */
public interface AnimalTypeRepository extends CrudRepository<AnimalType, Integer> {

	@Query("select * from animaltype where animalType = :animalType ")
	AnimalType findTypeByName(@Param(value = "animalType") String animalType);

}
