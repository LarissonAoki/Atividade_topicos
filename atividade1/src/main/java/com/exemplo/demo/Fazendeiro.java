package com.exemplo.demo;

import java.util.Random;

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
	public void comprar(int quant, Porco porco) {
		System.out.println("Saldo antes da compra: " + this.saldo);
		float valor_compra = quant*porco.valor();
		System.out.println("valor da compra: " + valor_compra);
		this.saldo -= valor_compra;	
		System.out.println("Novo valor do saldo: " + this.saldo);
	}
	
	@Override
	public int contar() {
		Random r = new Random();
		int quant = r.nextInt(71);
		
		return quant+30;
	}
	
	
	
}
