package com.mutants.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mutants.entities.Mutant;

@Repository
public interface MutantRepository extends CrudRepository<Mutant, Long> {

}
