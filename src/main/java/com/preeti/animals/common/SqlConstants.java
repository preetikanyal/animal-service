package com.preeti.animals.common;

/**
 * Constants related to sql
 *
 */
public class SqlConstants {
	public static final String INSERT_ANIMAL = "insert into animal(name, animal_type, move_type) " + "values (?, ?, ?)";
	public static final String FIND_ALL_ANIMALS = "select * from animal";
	public static final String FIND_ANIMAL_BY_NAME = "select * from animal where name = ?";
	public static final String DELETE_ANIMAL_BY_NAME = "delete from animal where name = ?";
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String MOVE_TYPE = "move_Type";
	public static final String ANIMAL_TYPE = "animal_Type";

}
