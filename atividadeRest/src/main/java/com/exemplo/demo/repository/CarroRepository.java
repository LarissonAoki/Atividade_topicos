package com.exemplo.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.exemplo.demo.model.Carros;

public interface CarroRepository extends CrudRepository<Carros, Long>{
	
	public List<Carros> findByModelo(String modelo);
	
	
	@Query("SELECT carro FROM Carros carro WHERE carro.cor = ?1")
	public List<Carros> lista_cores(String cor);
	
}
