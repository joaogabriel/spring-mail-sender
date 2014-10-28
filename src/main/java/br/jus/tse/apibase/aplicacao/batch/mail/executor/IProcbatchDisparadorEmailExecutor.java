package br.jus.tse.apibase.aplicacao.batch.mail.executor;

import br.jus.tse.apibase.aplicacao.batch.mail.exception.ProcbatchDisparadorEmailException;
import br.jus.tse.apibase.aplicacao.batch.mail.tasklet.IProcbatchDisparadorEmailTasklet;

public interface IProcbatchDisparadorEmailExecutor {

	void execute(IProcbatchDisparadorEmailTasklet disparadorEmailTasklet, IProcbatchDisparadorEmailExecutor disparadorEmailExecutor)
		throws ProcbatchDisparadorEmailException;
	
}
