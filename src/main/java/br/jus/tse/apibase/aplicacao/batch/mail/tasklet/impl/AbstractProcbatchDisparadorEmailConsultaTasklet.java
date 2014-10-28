package br.jus.tse.apibase.aplicacao.batch.mail.tasklet.impl;

import br.jus.tse.apibase.aplicacao.batch.mail.exception.ProcbatchDisparadorEmailException;
import br.jus.tse.apibase.aplicacao.batch.mail.executor.IProcbatchDisparadorEmailExecutor;
import br.jus.tse.apibase.aplicacao.batch.mail.tasklet.IProcbatchDisparadorEmailTasklet;

public abstract class AbstractProcbatchDisparadorEmailConsultaTasklet implements IProcbatchDisparadorEmailTasklet {

	private IProcbatchDisparadorEmailExecutor disparadorEmailExecutor;
	
	public void execute() throws ProcbatchDisparadorEmailException {
		disparadorEmailExecutor.execute(this, disparadorEmailExecutor);
	}
	
	public IProcbatchDisparadorEmailExecutor getDisparadorEmailExecutor() {
		return disparadorEmailExecutor;
	}
	
	public void setDisparadorEmailExecutor(IProcbatchDisparadorEmailExecutor disparadorEmailExecutor) {
		this.disparadorEmailExecutor = disparadorEmailExecutor;
	}
	
}
