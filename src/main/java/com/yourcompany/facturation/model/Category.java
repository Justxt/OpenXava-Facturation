package com.yourcompany.facturation.model;


import javax.persistence.*;

import lombok.*;

@Entity 
@Getter @Setter

public class Category extends Identifiable {
	
	@Column(length=50)
	String description;
}
