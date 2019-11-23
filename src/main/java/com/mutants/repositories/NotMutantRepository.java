package com.mutants.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mutants.entities.NotMutant;

@Repository
public interface NotMutantRepository extends CrudRepository<NotMutant,Long> {

}
