package br.jus.tse.testespring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesteGridDinamica {

	private String[] colunas;
	private List<List<String>> valores;
	
	public TesteGridDinamica() {
		valores = new ArrayList<List<String>>();
	}
	
	public void colunas(String... colunas) {
		this.colunas = colunas;
	}
	
	public void adicionarLinha(String... linha) {
		valores.add(Arrays.asList(linha));
	}
	
	/*public static void main(String[] args) {
		TesteGridDinamica gridDinamica = new TesteGridDinamica();
		gridDinamica.colunas("teste", "teste2", "teste3");
		gridDinamica.valores("1", "2", "3");
		
		System.out.println("<thead>");
		System.out.println("<tr>");
		
		for (String coluna : gridDinamica.colunas) {
			System.out.println("<th>" + coluna + "</th>");
		}
		
		System.out.println("</tr>");
		System.out.println("</thead>");
		
		System.out.println("<tbody>");
		System.out.println("<tr>");
		
		for (String valor : gridDinamica.valores) {
			System.out.println("<td>" + valor + "</td>");
		}
		
		System.out.println("</tr>");
		System.out.println("</tbody>");
	}*/
	
	public static void main(String[] args) {
		Pessoa p1 = new Pessoa("Maria", "SCS", "3354");
		Pessoa p2 = new Pessoa("Joana", "Noroteste", "8148");
		Pessoa p3 = new Pessoa("Camila", "Sudoca", "2567");
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		
		TesteGridDinamica gridDinamica = new TesteGridDinamica();
		gridDinamica.colunas("Nome", "Endereço", "Telefone");
		
		for (Pessoa p : pessoas) {
			gridDinamica.adicionarLinha(p.getNome(), p.getEndereco(), p.getTelefone());
		}
		
		System.out.println("<thead>");
		System.out.println("<tr>");
		
		for (String coluna : gridDinamica.colunas) {
			System.out.println("<th>" + coluna + "</th>");
		}
		
		System.out.println("</tr>");
		System.out.println("</thead>");
		
		System.out.println("<tbody>");
		
		for (List<String> vals : gridDinamica.valores) {
			System.out.println("<tr>");
			
			for (String valor : vals) {
				System.out.println("<td>" + valor + "</td>");
			}
			
			System.out.println("</tr>");
		}
		
		System.out.println("</tbody>");
	}
	
}
