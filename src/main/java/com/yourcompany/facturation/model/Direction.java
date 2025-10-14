package com.yourcompany.facturation.model;

import javax.persistence.*;

import lombok.*;


 @Embeddable @Getter @Setter
public class Direction {
	 
	 @Column(length=30)
	 String street;
	 @Column(length=5)
	 int zipCode;
	 @Column(length=20)
	 String municipality;
	 @Column(length=30)
	 String province;

}