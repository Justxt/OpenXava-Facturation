package com.yourcompany.facturation.model;


import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;



@Entity @Getter @Setter 

public class Product {
	
	
	@Id @Column(length=9)
	int number;
	
	@Column(length=50) @Required
	String description;

	@ManyToOne
	(fetch=FetchType.LAZY,optional=true)
	@DescriptionsList
	Category category;
	
	@Money
	BigDecimal price;
	
	@Files
	@Column(length=32)
	String images;
	
	@TextArea
	String comments;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList
	Author author;

}