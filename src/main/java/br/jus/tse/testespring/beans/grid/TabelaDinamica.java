package br.jus.tse.testespring.beans.grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TabelaDinamica {

	private String[] colunas;
	private List<List<String>> valores;

	public TabelaDinamica() {
		valores = new ArrayList<List<String>>();
	}
	
	public void colunas(String... colunas) {
		this.colunas = colunas;
	}
	
	public void adicionarLinha(String... linha) {
		valores.add(Arrays.asList(linha));
	}
	
	@Override
	public String toString() {
		StringBuilder html = new StringBuilder();
		html.append("<thead>");
		html.append("<tr>");
		
		for (String coluna : colunas) {
			html.append("<th>" + coluna + "</th>");
		}
		
		html.append("</tr>");
		html.append("</thead>");
		
		html.append("<tbody>");
		
		for (List<String> vals : valores) {
			html.append("<tr>");
			
			for (String valor : vals) {
				html.append("<td>" + valor + "</td>");
			}
			
			html.append("</tr>");
		}
		
		html.append("</tbody>");
		
		return html.toString();
	}

}
