package br.jus.tse.testespring.beans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.jus.tse.testespring.beans.service.EleicaoService;

@Controller
public class EleicaoController {

	@Autowired
	private EleicaoService eleicaoService;
	
	public void divulgarResultados() {
		eleicaoService.divulgarResultados();
	}
	
}
