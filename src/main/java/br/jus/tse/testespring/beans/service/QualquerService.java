package br.jus.tse.testespring.beans.service;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.jus.tse.testespring.beans.mail.ProcbatchMailSender;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

@Service
public class QualquerService {

	@Autowired
	private ProcbatchMailSender procbatchMailSender;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void executarJob() {
		
		try {
			MimeMessageHelper message = new MimeMessageHelper(mailSender.createMimeMessage());
			message.setFrom("secad@tse.jus.br", "Secad - Procbatch");
			message.setTo("joao.esteves@tse.jus.br");
			message.setSubject("Execução de Anomalias da Filiação Partidária");
			message.setText(getHTML(), true);
			
			mailSender.send(message.getMimeMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private String getHTML() throws Exception {
		/*
		 * ----------------------------------------------------------------------
		 * -
		 */
		/* You should do this ONLY ONCE in the whole application life-cycle: */

		/* Create and adjust the configuration */
		Configuration cfg = new Configuration();

//		cfg.setDirectoryForTemplateLoading(new File("C:\\env-dev\\git\\spring-mail-sender\\src\\main\\resources"));
		cfg.setDirectoryForTemplateLoading(new File("E:\\ambdes-extend\\ProjetosGIT\\spring-mail-sender\\src\\main\\resources"));
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		cfg.setIncompatibleImprovements(new Version(2, 3, 20));

		/*
		 * ----------------------------------------------------------------------
		 * -
		 */
		/* You usually do these for many times in the application life-cycle: */

		/* Create a data-model */
		Map root = new HashMap();
		root.put("titulo", "Inconsistências do Filiaweb");
		/*Map latest = new HashMap();
		root.put("latestProduct", latest);
		latest.put("url", "products/greenmouse.html");
		latest.put("name", "green mouse");*/

		/* Get the template */
		Template temp = cfg.getTemplate("template.ftl");

		/* Merge data-model with template */
//		Writer out = new OutputStreamWriter(System.out);
		Writer out = new StringWriter();
		temp.process(root, out);
		
		return out.toString();
	}
	
}
