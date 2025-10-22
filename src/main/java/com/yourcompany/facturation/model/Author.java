package com.yourcompany.facturation.model;

import java.util.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;


@Entity @Getter @Setter

public class Author {
	
	@Id @GeneratedValue(generator="system-uuid")
	@Hidden
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@Column(length=32)
	String oid;
	
	@Column (length=50)
	String name;
	
	@OneToMany(mappedBy="author", cascade=CascadeType.REMOVE)
	@ListProperties("number, description, price")
	Collection<Product> product;

}

