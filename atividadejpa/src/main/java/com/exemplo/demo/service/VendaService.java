package com.exemplo.demo.service;

import java.util.Date;
import java.util.List;

import com.exemplo.demo.model.Carros;
import com.exemplo.demo.model.Vendas;

public interface VendaService {
	
	public Vendas incluirVenda(int quant_carro, String vendedor, Date data, Carros idCarro);
	
	
	public float descontoUnidade(Vendas venda);
	
	public String funcionarioMes();

}
