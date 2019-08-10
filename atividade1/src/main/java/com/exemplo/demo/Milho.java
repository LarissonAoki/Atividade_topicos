package com.exemplo.demo;

public class Milho implements Alimento{
	
	private String tipo;
	private float valor_nutriente;
	private Porco animal;
	private String qualidade;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getValor_nutriente() {
		return valor_nutriente;
	}
	public void setValor_nutriente(int valor_nutriente) {
		this.valor_nutriente = valor_nutriente;
	}
	public Porco getAnimal() {
		return animal;
	}
	public void setAnimal(Porco animal) {
		this.animal = animal;
	}
	public String getQualidade() {
		return qualidade;
	}
	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}
	
	@Override
	public void getNutriente() {
		float nutriente = 0;
		if(this.qualidade.equals("seco")) {
			nutriente += 20;
		}else {
			nutriente += 50;
		}
		
		if(this.tipo.equals("mushroom")) {
			nutriente += 32;
		}else if(this.tipo.equals("midnight blue")){
			nutriente += 80;
		}else if (this.tipo.equals("midnight red")) {
			nutriente += 65;
		}
		
		this.valor_nutriente = nutriente;
	}
	
	

}
