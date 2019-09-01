package com.exemplo.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
import com.exemplo.demo.repository.VendaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class VendaRepositoryTest {
	
	@Autowired
	private CarroRepository repoCarro;
	
	@Autowired
	private VendaRepository repoVenda;
	
	@Before
	public void iniciar() {
		Date data = new Date();
		Carros c1 = new Carros("onix", 2016, 40000, "vermelho");
		Carros c2 = new Carros("gol", 2018, 30000, "preto");
		Carros c3 = new Carros("HB20", 2018, 60000, "prata");
		repoCarro.saveAll(Arrays.asList(c1,c2,c3));
		
		Vendas v1 = new Vendas(4, "beneito", data, c1);
		Vendas v2 = new Vendas(1, "camila", data, c2);
		Vendas v3 = new Vendas(3, "neusa", data, c3);
		Vendas v4 = new Vendas(1, "larissa", data, c1);
		Vendas v5 = new Vendas(2, "camila", data, c3);
		repoVenda.saveAll(Arrays.asList(v1,v2,v3,v4,v5));
	}
	
	@Test
	public void acimaDeCemMil() {
		List<Vendas> lista = repoVenda.listaAcimaCemMil();
		Boolean validado = true;
		for(Vendas v : lista) {
			if(v.getValor_total() < 100000) {
				validado = false;
				break;
			}
		}
		
		assertTrue(validado);
		assertEquals(3, lista.size());
		
	}
	
	@Test
	public void vendedorCamila() {
		List<Vendas> lista = repoVenda.findByVendedor("camila");
		Boolean validado = true;
		for(Vendas v : lista) {
			if(!v.getVendedor().equals("camila")) {
				validado = false;
				break;
			}
		}
		
		assertTrue(validado);
		assertEquals(2, lista.size());
	}

}
