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

import com.exemplo.demo.model.Vendas;
import com.exemplo.demo.service.VendaService;
import com.exemplo.demo.view.View;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping(value = "/venda")
public class VendaController {
	
	@Autowired
	private VendaService service;
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@JsonView(View.BuscaVenda.class)
	public ResponseEntity<Vendas> esquisar(@PathVariable("id") Long id) {
		Vendas venda = service.busca(id);
		if(venda == null) {
			return new ResponseEntity<Vendas>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Vendas>(venda, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/vendedor/{vendedor}", method = RequestMethod.GET)
	@JsonView(View.VendaVendedor.class)
	public ResponseEntity<Collection<Vendas>> getModelos(@PathVariable("vendedor") String vendedor){
		List<Vendas> listaVendas = service.vendas(vendedor);
		if (listaVendas == null) {
			return new ResponseEntity<Collection<Vendas>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Vendas>>(listaVendas, HttpStatus.OK);
		
	}

}
