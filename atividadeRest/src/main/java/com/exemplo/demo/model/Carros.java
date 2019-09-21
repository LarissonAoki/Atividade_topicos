package com.exemplo.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.exemplo.demo.view.*;

@Entity
@Table(name = "CARROS")
public class Carros {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CARRO_ID")
	@JsonView({View.CadastroCarro.class, View.CarroModelo.class, View.VendaVendedor.class})
	private Long id;
	
	@Column(name = "CARRO_MODELO")
	@JsonView({View.BuscaCarro.class, View.CarroModelo.class, View.VendaVendedor.class})
	private String modelo;
	
	@Column(name = "CARRO_ANO")
	@JsonView({View.CadastroCarro.class})
	private int ano;
		
	@Column(name = "CARRO_PRECO")
	@JsonView({View.BuscaCarro.class, View.CarroModelo.class})
	private float preco;
	
	@Column(name = "CARRO_COR")
	@JsonView({View.CadastroCarro.class})
	private String cor;
	
	
	public Carros() {}
	
	public Carros(String modelo, int ano, float preco, String cor) {
		super();
		this.modelo = modelo;
		this.ano = ano;
		this.preco = preco;
		this.cor = cor;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
}
