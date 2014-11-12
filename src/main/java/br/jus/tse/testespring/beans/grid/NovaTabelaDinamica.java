package br.jus.tse.testespring.beans.grid;

import java.util.List;

public class NovaTabelaDinamica {

	private List<String> colunas;
	
	/*
	 * Lista de TRs com lista de TDs
	 */
	private List<List<String>> valores;

	public List<String> getColunas() {
		return colunas;
	}

	public void setColunas(List<String> colunas) {
		this.colunas = colunas;
	}

	public List<List<String>> getValores() {
		return valores;
	}

	public void setValores(List<List<String>> valores) {
		this.valores = valores;
	}

}
