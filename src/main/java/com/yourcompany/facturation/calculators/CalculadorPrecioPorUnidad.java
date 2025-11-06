package com.yourcompany.facturation.calculators;

import static org.openxava.jpa.XPersistence.getManager;

import org.openxava.calculators.*;

import com.yourcompany.facturation.model.*;

import lombok.*;

public class CalculadorPrecioPorUnidad implements ICalculator {
	
	@Getter @Setter
	int productNumber;
	
	@Override
	public Object calculate() throws Exception {
		Product product = getManager()
				.find(Product.class, productNumber);
		return product.getPrice();
	}	

}
