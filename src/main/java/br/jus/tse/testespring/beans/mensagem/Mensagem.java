package br.jus.tse.testespring.beans.mensagem;

public class Mensagem {

	private String mensagem;
	private Severidade severidade;

	public Mensagem() {

	}

	public Mensagem(String mensagem, Severidade severidade) {
		this.mensagem = mensagem;
		this.severidade = severidade;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Severidade getSeveridade() {
		return severidade;
	}

	public void setSeveridade(Severidade severidade) {
		this.severidade = severidade;
	}

}
