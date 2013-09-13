package br.jus.tse.testespring.beans.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class EleicaoDAO {

	private Logger logger = Logger.getLogger(EleicaoDAO.class);
	
	public void divulgarResultados() {
		logger.info("Resultados divulgados");
	}
	
}
