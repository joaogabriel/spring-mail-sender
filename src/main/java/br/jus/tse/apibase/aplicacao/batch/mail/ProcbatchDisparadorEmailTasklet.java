package br.jus.tse.apibase.aplicacao.batch.mail;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

public class ProcbatchDisparadorEmailTasklet {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactory;
	
	@Autowired
	private ProcbatchDisparadorEmail procbatchDisparadorEmail;
	
	private String nomeRementente;
	private String emailRementente;
	private String template;
	
	// TODO substituir pelo identificador de ambientes
	private String ambiente;
	
	private Date dataExecucao;

	private InetAddress localHost;
	
	private String enderecoSistemaDesenvolvimento;
	private String enderecoSistemaHomologacao;
	private String enderecoSistemaProducao;
	
//	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
	public void execute() throws Exception {
		String htmlConteudo = null;
		Map<String, String> mapModel = null;
		
		try {
			dataExecucao = new Date();
			localHost = InetAddress.getLocalHost();
			
			// TODO parametrizar
			ambiente = "Produção";
			
			mapModel = criarMapModel();
			
			htmlConteudo = FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerConfigurationFactory.getObject().getTemplate(template), mapModel);
			
			System.out.println(htmlConteudo);
			
			// TODO implementar consultas
			
			MimeMessageHelper message = new MimeMessageHelper(mailSender.createMimeMessage());
			message.setFrom(emailRementente, nomeRementente);
			message.setTo(criarDestinatarios());
			message.setSubject(criarAssunto());
			message.setText(htmlConteudo, true);
			
			mailSender.send(message.getMimeMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Map<String, String> criarMapModel() {
		Map<String, String> mapModel = new HashMap<String, String>();
		
		// gerais
		mapModel.put("ambiente", ambiente);
		mapModel.put("nomeHostServidor", getNomeHostServidor());
		mapModel.put("enderecoIPServidor", getEnderecoIPServidor());
		mapModel.put("dataEnvio", getDataEnvio());
		mapModel.put("horarioEnvio", getHorarioEnvio());
		mapModel.put("enderecoSistema", getEnderecoSistemaPorAmbiente());
		
		// especificos
		mapModel.put("titulo", procbatchDisparadorEmail.getTitulo());
		mapModel.put("resumo", procbatchDisparadorEmail.getResumo());
		
		return mapModel;
	}
	
	private void definirAtributosPorAmbiente() {
		
	}
	
	private String criarAssunto() {
		String assunto = null;
		StringBuilder assuntoComAmbiente = null;
		
		if (ambiente.equals("Produção")) {
			assunto = procbatchDisparadorEmail.getAssunto();
		} else {
			assuntoComAmbiente = new StringBuilder();
			assuntoComAmbiente.append("[").append(ambiente).append("] ").append(procbatchDisparadorEmail.getAssunto());
			
			assunto = assuntoComAmbiente.toString();
		}
		
		return assunto;
	}
	
	private String[] criarDestinatarios() {
		String[] destinatarios = null;
		
		if (ambiente.equals("Produção")) {
			destinatarios = procbatchDisparadorEmail.getDestinatariosProducao().toArray(new String[0]);
		} else {
			destinatarios = procbatchDisparadorEmail.getDestinatariosPreProducao().toArray(new String[0]);
		}
		
		return destinatarios;
	}

	private String getNomeHostServidor() {
		return localHost.getHostName();
	}
	
	private String getEnderecoIPServidor() {
		return localHost.getHostAddress();
	}
	
	private String getDataEnvio() {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		return formatoData.format(dataExecucao);
	}

	private String getHorarioEnvio() {
		SimpleDateFormat formatoHorario = new SimpleDateFormat("HH:mm:ss");
		return formatoHorario.format(dataExecucao);
	}

	private String getEnderecoSistemaPorAmbiente() {
		return null;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setFreeMarkerConfigurationFactory(FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactory) {
		this.freeMarkerConfigurationFactory = freeMarkerConfigurationFactory;
	}

	public void setProcbatchDisparadorEmail(ProcbatchDisparadorEmail procbatchDisparadorEmail) {
		this.procbatchDisparadorEmail = procbatchDisparadorEmail;
	}

	public void setNomeRementente(String nomeRementente) {
		this.nomeRementente = nomeRementente;
	}

	public void setEmailRementente(String emailRementente) {
		this.emailRementente = emailRementente;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public void setDataExecucao(Date dataExecucao) {
		this.dataExecucao = dataExecucao;
	}

	public void setLocalHost(InetAddress localHost) {
		this.localHost = localHost;
	}

	public void setEnderecoSistemaDesenvolvimento(String enderecoSistemaDesenvolvimento) {
		this.enderecoSistemaDesenvolvimento = enderecoSistemaDesenvolvimento;
	}

	public void setEnderecoSistemaHomologacao(String enderecoSistemaHomologacao) {
		this.enderecoSistemaHomologacao = enderecoSistemaHomologacao;
	}

	public void setEnderecoSistemaProducao(String enderecoSistemaProducao) {
		this.enderecoSistemaProducao = enderecoSistemaProducao;
	}
	
}
