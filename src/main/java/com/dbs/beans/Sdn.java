package com.dbs.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sdn {

	@Id
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Sdn [name=" + name + "]";
	}

	public Sdn(String name) {
		super();
		this.name = name;
	}

	public Sdn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
