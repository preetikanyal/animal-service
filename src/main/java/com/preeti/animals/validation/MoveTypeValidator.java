package com.preeti.animals.validation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.preeti.animals.entity.MoveType;
import com.preeti.animals.service.MoveTypeService;

/**
 * This class validates the MoveType data
 * 
 */
public class MoveTypeValidator implements ConstraintValidator<MoveTypeConstraint, String> {

	@Autowired
	MoveTypeService moveTypeService;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		List<MoveType> animals = moveTypeService.findMoveTypes();
		return (animals.stream().filter(o -> o.getMoveType().equals(value)).findFirst().isPresent());
	}
}
