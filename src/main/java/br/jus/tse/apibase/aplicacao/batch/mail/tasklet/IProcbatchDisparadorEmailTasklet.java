package br.jus.tse.apibase.aplicacao.batch.mail.tasklet;

import java.util.List;

import br.jus.tse.apibase.aplicacao.batch.mail.conteudo.tabela.ConsultaEmail;
import br.jus.tse.apibase.aplicacao.batch.mail.exception.ProcbatchDisparadorEmailException;

public interface IProcbatchDisparadorEmailTasklet {

	void execute() throws ProcbatchDisparadorEmailException;

	String getAssunto();
	
	String getTitulo();
	
	String getResumo();

	List<String> getDestinatariosPreProducao();

	List<String> getDestinatariosProducao();

	List<ConsultaEmail> getConsultas();

}
