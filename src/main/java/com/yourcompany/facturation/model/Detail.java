package com.yourcompany.facturation.model;


import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.yourcompany.facturation.calculators.*;

import lombok.*;

@Embeddable @Getter @Setter

public class Detail {
	int amount;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	Product product;
	
	@Stereotype("MONEY")
	@Depends("priceByUnit, quantity")
	public BigDecimal getImporte() {
		if (priceByUnit == null ) return BigDecimal.ZERO;
		return new BigDecimal(amount).multiply(priceByUnit);
	}
	
	@DefaultValueCalculator(value = CalculadorPrecioPorUnidad.class,
			properties = @PropertyValue(name = "productNumber", from = "product.number"))
	@Stereotype("MONEY")
	BigDecimal priceByUnit;
}