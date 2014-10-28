package br.jus.tse.apibase.aplicacao.batch.mail.tasklet.impl;

import java.util.List;

import br.jus.tse.apibase.aplicacao.batch.mail.conteudo.tabela.ConsultaEmail;
import br.jus.tse.apibase.aplicacao.batch.mail.tasklet.IProcbatchDisparadorEmailTasklet;

public class ProcbatchDisparadorEmailConsultaTasklet extends AbstractProcbatchDisparadorEmailConsultaTasklet implements IProcbatchDisparadorEmailTasklet {

	private String assunto;
	private String titulo;
	private String resumo;
	private List<String> destinatariosPreProducao;
	private List<String> destinatariosProducao;
	private List<ConsultaEmail> consultas;

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public List<String> getDestinatariosPreProducao() {
		return destinatariosPreProducao;
	}

	public void setDestinatariosPreProducao(
			List<String> destinatariosPreProducao) {
		this.destinatariosPreProducao = destinatariosPreProducao;
	}

	public List<String> getDestinatariosProducao() {
		return destinatariosProducao;
	}

	public void setDestinatariosProducao(List<String> destinatariosProducao) {
		this.destinatariosProducao = destinatariosProducao;
	}

	public List<ConsultaEmail> getConsultas() {
		return consultas;
	}
	
	public void setConsultas(List<ConsultaEmail> consultas) {
		this.consultas = consultas;
	}

}
