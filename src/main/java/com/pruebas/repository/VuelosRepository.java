package com.pruebas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pruebas.entity.Vuelo;

@Repository
public interface VuelosRepository extends CrudRepository<Vuelo, Integer> {
	
	

}
