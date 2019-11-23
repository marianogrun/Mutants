package com.mutants.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.context.annotation.Description;

@Entity
@DiscriminatorValue("NOT_HUMAN")
public class NotMutant extends Human {
	
	public NotMutant () {
		
	}
	
	public NotMutant (Human human) {
		this.dna=human.dna;
	}
}
