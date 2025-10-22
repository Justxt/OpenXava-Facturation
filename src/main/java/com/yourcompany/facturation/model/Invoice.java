package com.yourcompany.facturation.model;

import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.yourcompany.facturation.calculators.*;

import lombok.*;


@Entity @Getter @Setter
@View(members = 
				"year, number, date;" +
				"client;" + 
				"details" + 
				"comments"
				)


public class Invoice {
	
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Hidden
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column (length = 32)
	String oid;
	
	
	@DefaultValueCalculator(CurrentYearCalculator.class)
	@Column (length = 4) 
	int year;
	
	@Column (length= 6)
	@DefaultValueCalculator(value = CalculateNextNumberByYear.class,
	properties = @PropertyValue(name="year"))
	int number;
	
	@Required
	@DefaultValueCalculator(CurrentLocalDateCalculator.class)
	LocalDate date;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@ReferenceView("Simple")
	Client client;
	
	@ElementCollection
	@ListProperties("product.number, product.description,amount")
	Collection<Detail> details;
	
	@Stereotype("MEMO")
	String comments;
}