package br.jus.tse.apibase.aplicacao.batch.mail.model;

import java.util.Date;

public class EnvioJobMail {

	private Long jobInstanceId;
	private Date data;
	private Integer sucesso;
	private String destinatarios;
	private Long quantidadeRegistrosManipulados;
	
}
