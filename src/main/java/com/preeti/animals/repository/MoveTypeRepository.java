package com.preeti.animals.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.preeti.animals.entity.MoveType;

/**
 * Repository for handling DB CRUD operations for MoveType entity
 * 
 */
public interface MoveTypeRepository extends CrudRepository<MoveType, Integer>{
	
	@Query("select * from MOVE_TYPE where MOVE_TYPE = :moveType ")
	MoveType findMoveByName(@Param(value = "moveType") String moveType);

}
