package br.jus.tse.testespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.jus.tse.testespring.beans.service.QualquerService;

public class InitApplicationContext {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        
        QualquerService qualquerService = applicationContext.getBean(QualquerService.class);
        
        qualquerService.executarJob();
        
        
    }
	
}
