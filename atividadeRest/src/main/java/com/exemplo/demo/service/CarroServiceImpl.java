package com.exemplo.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.demo.model.Carros;
import com.exemplo.demo.repository.CarroRepository;

import org.springframework.transaction.annotation.Transactional;

@Service("carroService")
public class CarroServiceImpl implements CarroService{
	
	@Autowired
	private CarroRepository repo_carro;

	@Transactional
	@Override
	public Carros incluirCarro(String modelo, int ano, float preco, String cor) {
		
		Carros c = new Carros();
		c.setModelo(modelo);
		c.setAno(ano);
		c.setPreco(preco);
		c.setCor(cor);
		repo_carro.save(c);
		
		return c;
	}

	@Override
	public List<Carros> estoque_cor(String cor) {
		return repo_carro.lista_cores(cor);
	}

	@Override
	public List<Carros> estoque_modelo(String modelo) {
		return repo_carro.findByModelo(modelo);
	}

	@Override
	public Carros buscarID(Long id) {
		Optional<Carros> c =  repo_carro.findById(id);
		if(c.isPresent()) {
			return c.get();
		}
		return null;
	}
}
