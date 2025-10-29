package com.yourcompany.facturation.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
@View(extendsView = "super.DEFAULT",
	members="orders{orders}"
	)
@View(name="NoClientInvoice",
		members=
		"year, number, date"
		+ "details;"
		+ "comments"
		)
public class Invoice extends CommercialDocument {
	
	@OneToMany(mappedBy = "invoice")
	@CollectionView("NoClientInvoice")
	Collection<Order> orders;
	
}

