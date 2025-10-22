package com.yourcompany.facturation.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;


@Entity @Getter @Setter
@View(name = "Simple", members = "number, name")


public class Client {
	
	@Id
	@Column(length=6)
	int number;
	
	@Column(length=50)
	@Required
	String name;
	
	@Embedded @NoFrame
	Direction direction;
}