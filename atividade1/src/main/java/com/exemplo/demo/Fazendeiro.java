package com.exemplo.demo;

public class Fazendeiro implements Pessoa{
	
	private String nome;
	private Porco rebanho;
	private Milho estoque_alimento;
	private float saldo;
	
	public Milho getEstoque_alimento() {
		return estoque_alimento;
	}
	public void setEstoque_alimento(Milho estoque_alimento) {
		this.estoque_alimento = estoque_alimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Porco getRebanho() {
		return rebanho;
	}
	public void setRebanho(Porco rebanho) {
		this.rebanho = rebanho;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	@Override
	public float comprar() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int contar() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
