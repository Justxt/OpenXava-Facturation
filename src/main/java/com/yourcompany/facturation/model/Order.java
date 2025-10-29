package com.yourcompany.facturation.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
@View(extendsView="super.DEFAULT",
	members="invoice{invoice}"
	)
@View(name="NoClientInvoice",
		members=
		"year, number, date;"
		+ "details;"
		+ "comments"
		)
public class Order extends CommercialDocument {

	@ManyToOne
	@ReferenceView("NoClientInvoice")
	Invoice invoice;

}
