package com.exemplo.demo.service;


import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.demo.model.Carros;
import com.exemplo.demo.model.Vendas;
import com.exemplo.demo.repository.VendaRepository;

@Service("vendaService")
public class VendaServiceImpl implements VendaService{
	
	@Autowired
	private VendaRepository vendaRepo;

	@Override
	public Vendas incluirVenda(int quant_carro, String vendedor, Date data, Carros idCarro) {
		Vendas v = new Vendas();
		v.setCarro(idCarro);
		v.setQuant_carro(quant_carro);
		v.setValor_total(quant_carro*idCarro.getPreco());
		v.setVendedor(vendedor);
		v.setData(data);
		
		vendaRepo.save(v);
		
		return v;
	}

	@Override
	public float descontoUnidade(Vendas venda) {
		
		if(venda.getQuant_carro() >= 3) {
			float desconto = (float) (venda.getValor_total()*0.3);
			venda.setValor_total(venda.getValor_total() - desconto);
		}
		
		return venda.getValor_total();
	}

	@Override
	public String funcionarioMes() {
		
		List<Vendas> vendas = vendaRepo.findAll();
		
		Set<String> vendedores = new HashSet<>();
		for(Vendas v: vendas) {
			vendedores.add(v.getVendedor());
		}
		
		Map<String,Integer> dicionario = new HashMap<>();
		for(String s : vendedores) {
			dicionario.put(s, vendaRepo.findByVendedor(s).size());
		}
		
		Map<String, Integer> sorted  = dicionario.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,LinkedHashMap::new));
		
		
		
		return sorted.entrySet().iterator().next().getKey();
	}

}
