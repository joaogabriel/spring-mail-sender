package br.jus.tse.testespring.beans.mail;

import br.jus.tse.testespring.beans.grid.TabelaDinamica;
import br.jus.tse.testespring.beans.mensagem.Mensagem;
import br.jus.tse.testespring.beans.mensagem.Severidade;

public class ProcbatchMailBuilder {

	private ProcbatchMail procbatchMail;
	
	public ProcbatchMailBuilder() {
		procbatchMail = new ProcbatchMail();
	}
	
	public ProcbatchMailBuilder assunto(String assunto) {
		procbatchMail.setAssunto(assunto);
		return this;
	}
	
	public ProcbatchMailBuilder adicionarDestinatarioEmDesenvolvimento(String destinatario) {
		procbatchMail.getDestinatariosEmDesenvolvimento().add(destinatario);
		return this;
	}
	
	public ProcbatchMailBuilder adicionarDestinatarioEmProducao(String destinatario) {
		procbatchMail.getDestinatariosEmProducao().add(destinatario);
		return this;
	}
	
	public ProcbatchMailBuilder adicionarMensagem(Mensagem mensagem) {
//		procbatchMail.getDestinatariosEmProducao().add(destinatario);
		return this;
	}
	
	public ProcbatchMailBuilder adicionarMensagem(String mensagem, Severidade severidade) {
		new Mensagem(mensagem, severidade);
//		procbatchMail.getDestinatariosEmProducao().add(destinatario);
		return this;
	}
	
	public ProcbatchMailBuilder adicionarTabela(TabelaDinamica tabela) {
//		procbatchMail.getDestinatariosEmProducao().add(destinatario);
		return this;
	}
	
	public ProcbatchMail build() {
		return procbatchMail;
	}
	
}
