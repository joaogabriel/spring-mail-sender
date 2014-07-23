package br.jus.tse.testespring.beans.mail;

import java.util.ArrayList;
import java.util.List;

import br.jus.tse.testespring.beans.grid.TabelaDinamica;
import br.jus.tse.testespring.beans.mensagem.Mensagem;

class ProcbatchMail {

	private List<String> destinatariosEmDesenvolvimento;
	private List<String> destinatariosEmProducao;
	private List<TabelaDinamica> tabelas;
	private List<Mensagem> mensagens;
	private String assunto;
	private String titulo;
	private String descricao;
	private String ambiente;
	private String host;
	private String data;

	ProcbatchMail() {
		destinatariosEmDesenvolvimento = new ArrayList<String>();
		destinatariosEmProducao = new ArrayList<String>();
	}
	
	public List<String> getDestinatariosEmDesenvolvimento() {
		return destinatariosEmDesenvolvimento;
	}

	public void setDestinatariosEmDesenvolvimento(List<String> destinatariosEmDesenvolvimento) {
		this.destinatariosEmDesenvolvimento = destinatariosEmDesenvolvimento;
	}

	public List<String> getDestinatariosEmProducao() {
		return destinatariosEmProducao;
	}

	public void setDestinatariosEmProducao(List<String> destinatariosEmProducao) {
		this.destinatariosEmProducao = destinatariosEmProducao;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

}
