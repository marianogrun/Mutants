package com.mutants.entities;

import javax.persistence.*;


@Entity
@Table (name="human")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Human {
	

	protected Long id; 
	protected String []dna;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	public String[] getDna() {
		return dna;
	}
	public void setDna(String[] dna) {
		this.dna = dna;
	}
	
	
	

}
