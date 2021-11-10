package com.preeti.animals.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.preeti.animals.common.CachingConstansts;
import com.preeti.animals.entity.MoveType;
import com.preeti.animals.repository.MoveTypeRepository;
import com.preeti.animals.service.MoveTypeService;

/**
 * Service class for handling business logic for MoveType entity
 * 
 */
@Service
public class MoveTypeServiceImpl implements MoveTypeService {

	@Autowired
	MoveTypeRepository moveTypeRepo;

	@Override
	public MoveType findMoveTypeByName(String name) {
		List<MoveType> list = findMoveTypes();
		return list.stream().filter(a -> a.getMoveType().equals(name)).findFirst().get();
	}

	@Override
	@Cacheable(CachingConstansts.MOVE_TYPES)
	public List<MoveType> findMoveTypes() {
		return (List<MoveType>) moveTypeRepo.findAll();
	}

}
