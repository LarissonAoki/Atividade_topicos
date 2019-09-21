package com.exemplo.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
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
import com.exemplo.demo.repository.CarroRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback

public class CarroRepositoryTest {

	@Autowired
	private CarroRepository repoCarro;
	
	@Before
	public void iniciar() {
		Carros c1 = new Carros("onix", 2016, 40000, "vermelho");
		Carros c2 = new Carros("gol", 2018, 30000, "preto");
		Carros c3 = new Carros("HB20", 2018, 60000, "prata");
		Carros c4 = new Carros("prisma", 2019, 50000, "azul");
		Carros c5 = new Carros("gol", 2009, 28000, "prata");
		repoCarro.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
	}
	
	@Test
	public void modelo_gol() {
		List<Carros> gols = repoCarro.findByModelo("gol");
		Boolean modeloGol = true;
		for(Carros c : gols) {
			if(!c.getModelo().equals("gol")) {
				modeloGol = false;
				break;
			}
		}
		
		assertTrue(modeloGol);
		assertEquals(gols.size(), 2);
		
	}
	
	@Test
	public void cor_vermelho() {
		List<Carros> vermelhos = repoCarro.lista_cores("vermelho");
		Boolean corVermelho = true;
		for(Carros c : vermelhos) {
			if(!c.getModelo().equals("vermelho")) {
				corVermelho = false;
				break;
			}
		}
		
		assertTrue(corVermelho);
		assertEquals(vermelhos.size(), 2);
	}
}
