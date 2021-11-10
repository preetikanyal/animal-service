package com.preeti.animals.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Custom validation constraint for AnimalType data
 * 
 */
@Documented
@Constraint(validatedBy = AnimalTypeValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AnimalTypeConstraint {
	String message() default "Invalid value for Animal type";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
