package br.jus.tse.testespring.beans.grid;

import java.util.Set;

public class Tabela {

	private Set<Linha> cabecalho;
	private Set<Linha> corpo;

	public Set<Linha> getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(Set<Linha> cabecalho) {
		this.cabecalho = cabecalho;
	}

	public Set<Linha> getCorpo() {
		return corpo;
	}

	public void setCorpo(Set<Linha> corpo) {
		this.corpo = corpo;
	}

}
