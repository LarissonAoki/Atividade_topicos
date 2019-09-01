package com.exemplo.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.exemplo.demo.model.Carros;
import com.exemplo.demo.model.Vendas;
import com.exemplo.demo.repository.CarroRepository;
import com.exemplo.demo.service.VendaService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class VendaServiceTest {

	@Autowired
	private VendaService service;
	
	@Autowired
	private CarroRepository repoCarro;
	
	Carros c1;
	Carros c2;
	Carros c3;
	
	Date data;
	
	@Before
	public void inserirCarro() {
		c1 = new Carros("modelo1", 2019, 30000, "preto");
		c2 = new Carros("modelo2", 2018, 40000, "prata");
		c3 = new Carros("modelo3", 2017, 34000, "azul");
		repoCarro.saveAll(Arrays.asList(c1,c2,c3));
				
	}
	
	
	@Test
	public void inserirVenda() {
		data = new Date();
		Vendas v = service.incluirVenda(2, "guilherme", data, c1);
		
		assertTrue(v.getId() != null);
		
	}
	
	@Test
	public void desconto() {
		data = new Date();
		Vendas v = service.incluirVenda(3, "natalia", data, c2);
		float valor = service.descontoUnidade(v);
		
		assertEquals(valor, 84000, 0);
	}
	
	@Test
	public void funcionarioMes() {
		data = new Date();
		Vendas v1 = service.incluirVenda(2, "larissa", data, c3);
		
		Vendas v2 = service.incluirVenda(2, "joao", data, c1);
		
		String nome = service.funcionarioMes();
		
		assertEquals(nome, "natalia");
	}
}
