package com.exemplo.demo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.exemplo.demo.model.Carros;
import com.exemplo.demo.service.CarroService;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class CarroServiceTest {
	
	@Autowired
	private CarroService service;
	
	
	@Test
	public void inserir() {		
		Carros c1 = service.incluirCarro("modelo1", 2018, 32000, "prata");
		assertTrue(c1.getId() != null);
	}
	
	@Test
	public void modelo() {
		List<Carros> lista = service.estoque_modelo("alfa");                                                                                                                 
		assertEquals(lista.size(), 1);
	}
	
	@Test
	public void cor() {
		List<Carros> lista = service.estoque_cor("prata");
		assertEquals(lista.size(), 1);
	}
	
}
