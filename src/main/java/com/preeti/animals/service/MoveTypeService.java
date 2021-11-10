/**
 * 
 */
package com.preeti.animals.service;

import java.util.List;

import com.preeti.animals.entity.MoveType;

/**
 * Service class for handling business logic for MoveType entity
 * 
 */
public interface MoveTypeService {
	MoveType findMoveTypeByName(String name);

	List<MoveType> findMoveTypes();
}
