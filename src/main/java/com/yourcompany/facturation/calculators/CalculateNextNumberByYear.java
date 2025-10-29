package com.yourcompany.facturation.calculators;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import lombok.*;





public class CalculateNextNumberByYear implements ICalculator{
		
		@Getter @Setter	
		int year;
		
		@Override
		
		public Object calculate() throws Exception {
			Query query = XPersistence.getManager()
					.createQuery("select max(f.number) from CommercialDocument f where f.year =:year");
			query.setParameter("year", year);
			Integer ultimoNumero = (Integer) query.getSingleResult();
			return ultimoNumero == null ? 1 : ultimoNumero + 1;
	}
}