package br.jus.tse.testespring.beans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.tse.testespring.beans.dao.EleicaoDAO;

@Service
public class EleicaoService {

	@Autowired
	private EleicaoDAO eleicaoDAO;
	
	public void divulgarResultados() {
		eleicaoDAO.divulgarResultados();
	}
	
}
