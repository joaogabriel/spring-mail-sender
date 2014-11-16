package br.jus.tse.testespring.beans.grid;

import java.util.List;

public class Linha {

	private List<Celula> celulas;

	public List<Celula> getCelulas() {
		return celulas;
	}

	public void setCelulas(List<Celula> celulas) {
		this.celulas = celulas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celulas == null) ? 0 : celulas.hashCode());
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
		Linha other = (Linha) obj;
		if (celulas == null) {
			if (other.celulas != null)
				return false;
		} else if (!celulas.equals(other.celulas))
			return false;
		return true;
	}

}
