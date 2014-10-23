package br.jus.tse.apibase.aplicacao.batch.mail.conteudo.tabela;

import java.util.Map;

public class TabelaDetalheEmail {

	private String titulo;
	private String descricao;
	private String indiceLinhas;
	private String sqlQuery;
	private Map<String, String> colunasMap;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIndiceLinhas() {
		return indiceLinhas;
	}

	public void setIndiceLinhas(String indiceLinhas) {
		this.indiceLinhas = indiceLinhas;
	}

	public String getSqlQuery() {
		return sqlQuery;
	}

	public void setSqlQuery(String sqlQuery) {
		this.sqlQuery = sqlQuery;
	}

	public Map<String, String> getColunasMap() {
		return colunasMap;
	}

	public void setColunasMap(Map<String, String> colunasMap) {
		this.colunasMap = colunasMap;
	}

}
