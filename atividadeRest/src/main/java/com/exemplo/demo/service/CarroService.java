package com.exemplo.demo.service;

import java.util.List;

import com.exemplo.demo.model.Carros;

public interface CarroService {

	public Carros incluirCarro(String modelo, int ano, float preco, String cor);
	public Carros buscarID(Long id);
	
	public List<Carros> estoque_cor(String cor);
	public List<Carros> estoque_modelo(String modelo);
	
}
