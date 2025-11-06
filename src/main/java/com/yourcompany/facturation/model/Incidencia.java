package com.yourcompany.facturation.model;

import lombok.*;

public class Incidencia {
	
	@Getter @Setter
	int amount;

	@Getter @Setter
	int price;
	
	public int getImporte() {
		return amount * price;
	}
	

}
