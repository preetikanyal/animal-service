package com.preeti.animals.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AnimalType {
	
    private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	
	private String animalType;

}
