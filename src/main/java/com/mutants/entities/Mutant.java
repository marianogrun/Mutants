package com.mutants.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("MUTANT")
public class Mutant extends Human {
	
	public Mutant () {
		
	}
	
	public Mutant (Human human) {
		this.dna=human.dna;
	}
}
