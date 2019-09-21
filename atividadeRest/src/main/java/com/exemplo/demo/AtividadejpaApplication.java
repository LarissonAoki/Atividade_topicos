package com.exemplo.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exemplo.demo.model.Carros;
import com.exemplo.demo.service.CarroService;
import com.exemplo.demo.service.VendaService;

@SpringBootApplication
public class AtividadejpaApplication implements CommandLineRunner{
	
	@Autowired
	private CarroService carroService;
	
	@Autowired
	private VendaService vendaService;
	

	public static void main(String[] args) {
		SpringApplication.run(AtividadejpaApplication.class, args);
	}
	
	public void setCarroService(CarroService carroService) {
		this.carroService = carroService;
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		//carroService.incluirCarro("modelox", 2018, 45000, "preto");
		
		/*
		Date data = new Date();
		Carros c1 = carroService.incluirCarro("jeep", 2016, 30000, "caqui");
		vendaService.incluirVenda(2, "natalia", data, c1);*/
	}

}
