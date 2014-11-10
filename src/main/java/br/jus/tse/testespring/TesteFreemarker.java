package br.jus.tse.testespring;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class TesteFreemarker {

	public static void main(String[] args) throws Exception {

		/*
		 * ----------------------------------------------------------------------
		 * -
		 */
		/* You should do this ONLY ONCE in the whole application life-cycle: */

		/* Create and adjust the configuration */
		Configuration cfg = new Configuration();

		cfg.setDirectoryForTemplateLoading(new File("C:\\env-dev\\git\\spring-mail-sender\\src\\main\\resources"));
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		cfg.setIncompatibleImprovements(new Version(2, 3, 20));

		/*
		 * ----------------------------------------------------------------------
		 * -
		 */
		/* You usually do these for many times in the application life-cycle: */

		List<String> nomes = new ArrayList<String>();
		nomes.add("Joao");
		nomes.add("Maria");
		nomes.add("Lulu");
		
		Map<String, List<String>> mapaComplexo = new HashMap<String, List<String>>();
		mapaComplexo.put("A", nomes);
		mapaComplexo.put("B", nomes);
		mapaComplexo.put("C", nomes);
		
		/* Create a data-model */
		Map root = new HashMap();
		root.put("titulo", "Zãoção");
		root.put("resumo", "Zãoção");
		root.put("horarioEnvio", "Zãoção");
		root.put("dataEnvio", "Zãoção");
		root.put("nomeHostServidor", "Zãoção");
		root.put("enderecoIPServidor", "Zãoção");
		root.put("ambiente", "Zãoção");
		root.put("nomes", nomes);
		root.put("mapa", mapaComplexo);
		root.put("param1", "ahvah");
		/*Map latest = new HashMap();
		root.put("latestProduct", latest);
		latest.put("url", "products/greenmouse.html");
		latest.put("name", "green mouse");*/

		/* Get the template */
		Template template = cfg.getTemplate("template-outlook2007.ftl");

		/* Merge data-model with template */
//		Writer out = new OutputStreamWriter(System.out);
		FileWriter fileWriter = new FileWriter("C:\\env-dev\\git\\spring-mail-sender\\src\\main\\resources\\gerado.html");
//		template.process(root, out);
		template.process(root, fileWriter);
	}

}
