package br.jus.tse.apibase.aplicacao.batch.mail.conteudo.tabela;

import java.util.Map;

public class ConsultaEmail {

	private String titulo;
	private String descricao;
	private String indiceLinhas;
	private String querySql;
	private String queryCountSql;
	private Map<String, String> colunasMap;

	public ConsultaEmail() {
		super();
	}
	
	public ConsultaEmail(String titulo) {
		super();
		this.titulo = titulo;
	}
	
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

	public String getQuerySql() {
		return querySql;
	}

	public void setQuerySql(String querySql) {
		this.querySql = querySql;
	}

	public String getQueryCountSql() {
		return queryCountSql;
	}

	public void setQueryCountSql(String queryCountSql) {
		this.queryCountSql = queryCountSql;
	}

	public Map<String, String> getColunasMap() {
		return colunasMap;
	}

	public void setColunasMap(Map<String, String> colunasMap) {
		this.colunasMap = colunasMap;
	}

	@Override
	public String toString() {
		return titulo;
	}
	
}
