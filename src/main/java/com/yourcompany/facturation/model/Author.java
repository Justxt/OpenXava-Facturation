package com.yourcompany.facturation.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;


@Entity @Getter @Setter

public class Author extends Identifiable {
	
	@Column (length=50)
	String name;
	
	@OneToMany(mappedBy="author", cascade=CascadeType.REMOVE)
	@ListProperties("number, description, price")
	Collection<Product> product;

}

