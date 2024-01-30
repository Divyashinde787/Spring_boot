package com.techhub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SampleEntity {

	@Id
	private String name;
	
	private String last_name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
}
