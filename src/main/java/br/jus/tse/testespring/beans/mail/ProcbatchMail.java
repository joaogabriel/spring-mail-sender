package br.jus.tse.testespring.beans.mail;

import java.util.ArrayList;
import java.util.List;

class ProcbatchMail {

	private List<String> destinatariosEmDesenvolvimento;
	private List<String> destinatariosEmProducao;
	private String assunto;

	ProcbatchMail() {
		destinatariosEmDesenvolvimento = new ArrayList<String>();
		destinatariosEmProducao = new ArrayList<String>();
	}
	
	public List<String> getDestinatariosEmDesenvolvimento() {
		return destinatariosEmDesenvolvimento;
	}

	public void setDestinatariosEmDesenvolvimento(
			List<String> destinatariosEmDesenvolvimento) {
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
