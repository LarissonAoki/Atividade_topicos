package com.exemplo.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AtividadeApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext(	"applicationContext.xml");
		
		Porco p1 = (Porco) context.getBean("porco1");
		Porco p2 = (Porco) context.getBean("porco2");
		Porco p3 = (Porco) context.getBean("porco3");
		
		System.out.println("valor de venda do porco1: " + p1.vender());
		System.out.println("valor de venda do porco2: " + p2.vender());
		System.out.println("valor de venda do porco3: " + p3.vender());
 
	}

}
