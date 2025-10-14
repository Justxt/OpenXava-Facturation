package com.yourcompany.facturation.model;


import javax.persistence.*;

import lombok.*;

@Embeddable @Getter @Setter

public class Detail {
	int cantidad;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	Product product;
}