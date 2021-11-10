/**
 * 
 */
package com.preeti.animals.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.preeti.animals.validation.AnimalTypeConstraint;
import com.preeti.animals.validation.MoveTypeConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author preeti
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class AnimalDTO {
	
	@NotEmpty	
	@NotNull
	private String name;
	
	@NotEmpty
	@NotNull
	@AnimalTypeConstraint
	private String animalType;
	
	@NotEmpty
	@NotNull
	@MoveTypeConstraint
	private String moveType;

}
