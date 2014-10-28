package br.jus.tse.apibase.aplicacao.batch.mail.tasklet;

import br.jus.tse.apibase.aplicacao.batch.mail.exception.ProcbatchDisparadorEmailException;
import br.jus.tse.apibase.aplicacao.batch.mail.executor.IProcbatchDisparadorEmailExecutor;

public interface IProcbatchDisparadorEmailTasklet {

	void execute() throws ProcbatchDisparadorEmailException;
	
}
