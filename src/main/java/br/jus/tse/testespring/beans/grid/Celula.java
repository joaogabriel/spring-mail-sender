package br.jus.tse.testespring.beans.grid;

public class Celula {

	private String conteudo;

	public Celula() {
		super();
	}
	
	public Celula(String conteudo) {
		super();
		this.conteudo = conteudo;
	}
	
	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((conteudo == null) ? 0 : conteudo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Celula other = (Celula) obj;
		if (conteudo == null) {
			if (other.conteudo != null)
				return false;
		} else if (!conteudo.equals(other.conteudo))
			return false;
		return true;
	}

}
