package com.preeti.animals.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Custom validation constraint for MoveType data
 * 
 */
@Documented
@Constraint(validatedBy = MoveTypeValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MoveTypeConstraint {
	String message() default "Invalid value for Movement type";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
