package com.mutants.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.mutants.entities.Human;

@Repository
public interface HumanRepository extends CrudRepository<Human, Long> {
		
	boolean existsByDna (String[] dna);
}
