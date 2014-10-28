package br.jus.tse.apibase.aplicacao.batch.mail.old;

import java.util.List;

import br.jus.tse.apibase.aplicacao.batch.mail.conteudo.tabela.TabelaDetalheEmail;

public class ProcbatchDisparadorEmail {

	private Boolean ativoApenasProducao;
	private String assunto;
	private String titulo;
	private String resumo;
	private List<String> destinatariosPreProducao;
	private List<String> destinatariosProducao;
	private List<TabelaDetalheEmail> tabelas;
	
	public Boolean getAtivoApenasProducao() {
		return ativoApenasProducao;
	}

	public void setAtivoApenasProducao(Boolean ativoApenasProducao) {
		this.ativoApenasProducao = ativoApenasProducao;
	}

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

	public List<TabelaDetalheEmail> getTabelas() {
		return tabelas;
	}

	public void setTabelas(List<TabelaDetalheEmail> tabelas) {
		this.tabelas = tabelas;
	}

}
