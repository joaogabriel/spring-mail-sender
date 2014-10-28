package br.jus.tse.apibase.aplicacao.batch.mail.model;

public class ConfiguracaoJobMail {

	private Long jobInstanceId;
	private Integer ativo;

	public Long getJobInstanceId() {
		return jobInstanceId;
	}

	public void setJobInstanceId(Long jobInstanceId) {
		this.jobInstanceId = jobInstanceId;
	}

	public Integer getAtivo() {
		return ativo;
	}
	
	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

}
