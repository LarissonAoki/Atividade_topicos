package com.exemplo.demo.web.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.demo.model.Carros;
import com.exemplo.demo.repository.CarroRepository;
import com.exemplo.demo.service.CarroService;
import com.exemplo.demo.view.View;
import com.fasterxml.jackson.annotation.JsonView;



@RestController
@RequestMapping(value = "/carro")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	public void setCarroService(CarroService CarroService) {
		this.carroService = CarroService;
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@JsonView(View.BuscaCarro.class)
	public ResponseEntity<Carros> esquisar(@PathVariable("id") Long id) {
		Carros carro = carroService.buscarID(id);
		if(carro == null) {
			return new ResponseEntity<Carros>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Carros>(carro, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/modelo/{modelo}", method = RequestMethod.GET)
	@JsonView(View.CarroModelo.class)
	public ResponseEntity<Collection<Carros>> getModelos(@PathVariable("modelo") String modelos){
		List<Carros> listaModelos = carroService.estoque_modelo(modelos);
		if (listaModelos == null) {
			return new ResponseEntity<Collection<Carros>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Carros>>(listaModelos, HttpStatus.OK);
		
	}
	
	
}
