package br.jus.tse.testespring.beans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.tse.testespring.beans.mail.ProcbatchMailSender;

@Service
public class QualquerService {

	@Autowired
	private ProcbatchMailSender procbatchMailSender;
	
	public void executarJob() {
		
	}
	
}
