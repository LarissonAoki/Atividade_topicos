package com.exemplo.demo.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exemplo.demo.model.Vendas;

@Repository
public interface VendaRepository extends CrudRepository<Vendas, Long>, JpaRepository<Vendas, Long>{
	
	public List<Vendas> findByVendedor(String nome);
	
	@Query("SELECT venda FROM Vendas venda WHERE venda.valor_total >= 100000")
	public List<Vendas> listaAcimaCemMil();
		
}
