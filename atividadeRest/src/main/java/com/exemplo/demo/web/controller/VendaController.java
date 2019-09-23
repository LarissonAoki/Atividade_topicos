package com.exemplo.demo.web.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.demo.model.Carros;
import com.exemplo.demo.model.Vendas;
import com.exemplo.demo.service.CarroService;
import com.exemplo.demo.service.VendaService;
import com.exemplo.demo.view.View;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping(value = "/venda")
public class VendaController {
	
	@Autowired
	private VendaService service;
	
	@Autowired
	private CarroService serviceCarro;
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@JsonView(View.BuscaVenda.class)
	public ResponseEntity<Vendas> pesquisar(@PathVariable("id") Long id) {
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
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.CadastroVend.class)
	public ResponseEntity<Vendas> save(@RequestBody Vendas venda, HttpServletRequest request, HttpServletResponse response) {
		Carros carro = serviceCarro.buscarID(venda.getCarro().getId());
		Vendas v = service.incluirVenda(venda.getQuant_carro(), venda.getVendedor(), venda.getData(),carro);
		if(carro != null && v!= null) {
			response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/venda/get/" + v.getId());
			return new ResponseEntity<Vendas>(v, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Vendas>(HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
}
