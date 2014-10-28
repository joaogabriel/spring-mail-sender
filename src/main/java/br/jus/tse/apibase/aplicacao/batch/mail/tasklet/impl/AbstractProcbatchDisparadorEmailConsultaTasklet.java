package br.jus.tse.apibase.aplicacao.batch.mail.tasklet.impl;

import br.jus.tse.apibase.aplicacao.batch.mail.exception.ProcbatchDisparadorEmailException;
import br.jus.tse.apibase.aplicacao.batch.mail.executor.IProcbatchDisparadorEmailExecutor;
import br.jus.tse.apibase.aplicacao.batch.mail.tasklet.IProcbatchDisparadorEmailTasklet;

// TODO deve implementar tambem um Tasklet do Spring Batch
public abstract class AbstractProcbatchDisparadorEmailConsultaTasklet implements IProcbatchDisparadorEmailTasklet {

	private IProcbatchDisparadorEmailExecutor disparadorEmailExecutor;
	
	// esta chamada deve ser do tasktet
	public void execute() throws ProcbatchDisparadorEmailException {
		disparadorEmailExecutor.execute(this);
	}
	
	public void setDisparadorEmailExecutor(IProcbatchDisparadorEmailExecutor disparadorEmailExecutor) {
		this.disparadorEmailExecutor = disparadorEmailExecutor;
	}
	
}
