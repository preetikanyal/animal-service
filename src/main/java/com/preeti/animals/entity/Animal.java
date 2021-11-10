/**
 * 
 */
package com.preeti.animals.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author preeti
 *
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

	 private static final long serialVersionUID = 1L;
	@Id
	private String id;
	
	private String name;

	
	private AnimalType animalType;

	
	private MoveType moveType;
}
