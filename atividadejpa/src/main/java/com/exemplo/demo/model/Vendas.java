package com.exemplo.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VENDAS")
public class Vendas {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "VENDA_ID")
	private Long id;
	
	@Column(name = "VENDA_QUAN")
	private int quant_carro;
	
	@Column(name = "VENDA_TOTAL")
	private float valor_total;
	
	@Column(name = "VENDA_VENDEDOR")
	private String vendedor;
	
	@Column(name = "VENDA_DATA")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "carro_id")
	private Carros carro;
	
	
	
	public Vendas() {
		super();
	}
	
	
	public Vendas(int quant_carro, String vendedor, Date data, Carros carro) {
		super();
		this.quant_carro = quant_carro;
		this.vendedor = vendedor;
		this.data = data;
		this.carro = carro;
		this.valor_total = carro.getPreco()*quant_carro;
	}


	public Carros getCarro() {
		return carro;
	}
	public void setCarro(Carros carro) {
		this.carro = carro;
	}
	public int getQuant_carro() {
		return quant_carro;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setQuant_carro(int quant_carro) {
		this.quant_carro = quant_carro;
	}
	public float getValor_total() {
		return valor_total;
	}
	public void setValor_total(float valor_total) {
		this.valor_total = valor_total;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	
	
	
}
