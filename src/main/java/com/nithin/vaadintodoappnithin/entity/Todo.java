package com.nithin.vaadintodoappnithin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "todos")
@Data
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String text;
	private boolean done;
	
	public Todo()
	{
		
	}
	
	public Todo(String text)
	{
		this.text = text;
	}
	

}
