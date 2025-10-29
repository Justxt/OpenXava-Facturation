package com.yourcompany.facturation.model;

import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.yourcompany.facturation.calculators.*;

import lombok.*;


@Entity @Getter @Setter
@View(members = 
				"year, number, date;" +
				"data{" +
				"client;" + 
				"details;" + 
				"comments"+
				"}"
				)


abstract public class CommercialDocument extends Identifiable {	
	
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