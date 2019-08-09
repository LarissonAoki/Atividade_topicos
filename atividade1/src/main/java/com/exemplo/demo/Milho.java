package com.exemplo.demo;

public class Milho implements Alimento{
	
	private String tipo;
	private int valor_nutriente;
	private Porco animal;
	private String qualidade;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getValor_nutriente() {
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
	public float getNutriente() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
