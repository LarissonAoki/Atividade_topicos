package com.exemplo.demo;

public class Porco implements Animal{
	
	private float peso;
	private String raça;
	private Milho alimento;
	private int idade;
	
	

	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getRaça() {
		return raça;
	}
	public void setRaça(String raça) {
		this.raça = raça;
	}

	public Milho getAlimento() {
		return alimento;
	}
	public void setAlimento(Milho alimento) {
		this.alimento = alimento;
	}

	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}



	@Override
	public float vender() {
		float valor = 0f;
		if(this.peso >= 1500) {
			valor += 300;
		}else if(this.peso < 1500 && this.peso >= 1000) {
			valor += 200;
		} else {
			valor += 100;
		}
		
		if(this.idade >= 8 && this.idade <=14) {
			valor += 200;
		}else {
			valor += 100;
		}
		
		if(this.raça.equals("large white")) {
			valor += 500;
		}else {
			valor += 240;
		}
		return valor;
	}

}
