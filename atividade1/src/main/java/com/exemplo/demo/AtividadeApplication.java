/*
 * Autores:
 * 	Ana Cristina Lima	
 * 	André Luiz Rodrigues
 * 	Larissa Soares Aoki
 * 	Lucy Brandão
 * 	Natalia Gonçalves
 * 	Natalia Marinho
 */

package com.exemplo.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AtividadeApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext(	"applicationContext.xml");
		
		Porco p1 = (Porco) context.getBean("porco");
		Milho m1 = (Milho) context.getBean("milho");
		Fazendeiro f1 = (Fazendeiro) context.getBean("fazendeiro");
		
		int quant = f1.contar();
		f1.setSaldo(quant*f1.getRebanho().valor());
		m1.getNutriente();
		
		System.out.println(" \n----- Fazenda " + f1.getNome()+ " ----- ");
		System.out.println(" Tipo de porco: " + f1.getRebanho().getRaça()
								+" (R$ "+p1.valor()+")");
		System.out.println(" Tipo de milho: " 
								+ f1.getEstoque_alimento().getTipo()
								+" ("+m1.getValor_nutriente()+" kcal)");
		System.out.println(" Total do rebanho: " + quant);
		System.out.println(" Saldo da Total: " + f1.getSaldo());
		
	}

}
