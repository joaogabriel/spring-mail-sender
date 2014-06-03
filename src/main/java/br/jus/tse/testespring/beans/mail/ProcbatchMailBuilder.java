package br.jus.tse.testespring.beans.mail;

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
	
	public ProcbatchMail build() {
		return procbatchMail;
	}
	
}
