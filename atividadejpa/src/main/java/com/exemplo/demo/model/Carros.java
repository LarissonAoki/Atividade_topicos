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

@Entity
@Table(name = "CARROS")
public class Carros {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CARRO_ID")
	private Long id;
	
	@Column(name = "CARRO_MODELO")
	private String modelo;
	
	@Column(name = "CARRO_ANO")
	private int ano;
		
	@Column(name = "CARRO_PRECO")
	private float preco;
	
	@Column(name = "CARRO_COR")
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
