package br.jus.tse.apibase.aplicacao.batch.mail.executor.impl;

import java.io.FileWriter;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import br.jus.tse.apibase.aplicacao.batch.mail.conteudo.tabela.ConsultaEmail;
import br.jus.tse.apibase.aplicacao.batch.mail.exception.ProcbatchDisparadorEmailException;
import br.jus.tse.apibase.aplicacao.batch.mail.executor.IProcbatchDisparadorEmailExecutor;
import br.jus.tse.apibase.aplicacao.batch.mail.tasklet.IProcbatchDisparadorEmailTasklet;
import br.jus.tse.testespring.beans.grid.Celula;
import br.jus.tse.testespring.beans.grid.Linha;
import br.jus.tse.testespring.beans.grid.NovaTabelaDinamica;
import br.jus.tse.testespring.beans.grid.Tabela;

public class ProcbatchDisparadorEmailConsultaExecutor implements IProcbatchDisparadorEmailExecutor {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactory;
	
	// TODO não deve ser injetado
	@Autowired
	private IProcbatchDisparadorEmailTasklet disparadorEmailTasklet;
	
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
	
	private Integer maximoRegistrosPorConsulta;
	
	private Map<ConsultaEmail, List<Map<String, Object>>> consultas;
	
	private Map<String, Object> mapModel = new HashMap<String, Object>();
	
	public void execute(IProcbatchDisparadorEmailTasklet disparadorEmailTasklet) throws ProcbatchDisparadorEmailException {
		String htmlConteudo = null;
		
		try {
//			this.disparadorEmailTasklet = disparadorEmailTasklet;
			
			dataExecucao = new Date();
			localHost = InetAddress.getLocalHost();
					
			// TODO parametrizar
			ambiente = "Produção";
			
			criarMapModel();
			
			// TODO implementar consultas
			executarConsultas();
			
			htmlConteudo = FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerConfigurationFactory.getObject().getTemplate(template), mapModel);
			
//			System.out.println(htmlConteudo);
			
			FileWriter fileWriter = new FileWriter("C:\\env-dev\\git\\spring-mail-sender\\src\\main\\resources\\gerado.html");
			fileWriter.append(htmlConteudo);
			fileWriter.close();
			
			/*MimeMessageHelper message = new MimeMessageHelper(mailSender.createMimeMessage());
			message.setFrom(emailRementente, nomeRementente);
			message.setTo(criarDestinatarios());
			message.setSubject(criarAssunto());
			message.setText(htmlConteudo, true);
			
			mailSender.send(message.getMimeMessage());*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// TODO guardar informacoes de envio no banco de dados
		}
	}

	private void executarConsultas() {
		/*Integer quantidadeRegistros = 0;
		
		for (ConsultaEmail consulta : disparadorEmailTasklet.getConsultas()) {
			// executar count
			quantidadeRegistros = 1;
			
			if (quantidadeRegistros < maximoRegistrosPorConsulta) {
				// executar consulta
			}
		}*/
		
		carregarConsultas();
		
		prepararTabelaDinamica();
	}

	private void criarMapModel() {
		// gerais
		mapModel.put("ambiente", ambiente);
		mapModel.put("nomeHostServidor", getNomeHostServidor());
		mapModel.put("enderecoIPServidor", getEnderecoIPServidor());
		mapModel.put("dataEnvio", getDataEnvio());
		mapModel.put("horarioEnvio", getHorarioEnvio());
		mapModel.put("enderecoSistema", getEnderecoSistemaPorAmbiente());
		
		// especificos
		mapModel.put("titulo", disparadorEmailTasklet.getTitulo());
		mapModel.put("resumo", disparadorEmailTasklet.getResumo());
	}
	
	private void definirAtributosPorAmbiente() {
		
	}
	
	private String criarAssunto() {
		String assunto = null;
		StringBuilder assuntoComAmbiente = null;
		
		if (ambiente.equals("Produção")) {
			assunto = disparadorEmailTasklet.getAssunto();
		} else {
			assuntoComAmbiente = new StringBuilder();
			assuntoComAmbiente.append("[").append(ambiente).append("] ").append(disparadorEmailTasklet.getAssunto());
			
			assunto = assuntoComAmbiente.toString();
		}
		
		return assunto;
	}
	
	private String[] criarDestinatarios() {
		String[] destinatarios = null;
		
		if (ambiente.equals("Produção")) {
			destinatarios = disparadorEmailTasklet.getDestinatariosProducao().toArray(new String[0]);
		} else {
			destinatarios = disparadorEmailTasklet.getDestinatariosPreProducao().toArray(new String[0]);
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
	
	private void carregarConsultas() {
		ConsultaEmail c1 = new ConsultaEmail("consulta 1");
		ConsultaEmail c2 = new ConsultaEmail("consulta 2");
		ConsultaEmail c3 = new ConsultaEmail("consulta 3");
		
		// reg 1
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("COD_OBJETO", "123");
		map1.put("SGL_UF", "DF");
		map1.put("DES_UF", "DISTRITO FEDERAL");
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("COD_OBJETO", "456");
		map2.put("SGL_UF", "SP");
		map2.put("DES_UF", "SAO PAULO");
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("COD_OBJETO", "789");
		map3.put("SGL_UF", "RJ");
		map3.put("DES_UF", "RIO DE JANEIRO");
		
		List<Map<String,Object>> lista1 = new ArrayList<Map<String,Object>>();
		lista1.add(map1);
		lista1.add(map2);
		lista1.add(map3);
		
		// reg 2
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("COD_OBJETO", "123");
		map4.put("SGL_UF", "SC");
		map4.put("DES_UF", "SANTA CATARINA");
		
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("COD_OBJETO", "456");
		map5.put("SGL_UF", "GO");
		map5.put("DES_UF", "GOIAS");
		
		Map<String, Object> map6 = new HashMap<String, Object>();
		map6.put("COD_OBJETO", "789");
		map6.put("SGL_UF", "TO");
		map6.put("DES_UF", "TOCANTIS");
		
		List<Map<String,Object>> lista2 = new ArrayList<Map<String,Object>>();
		lista2.add(map4);
		lista2.add(map5);
		lista2.add(map6);
		
		// reg 3
		Map<String, Object> map7 = new HashMap<String, Object>();
		map7.put("COD_OBJETO", "123");
		map7.put("SGL_UF", "MA");
		map7.put("DES_UF", "MARANHAO");
		
		Map<String, Object> map8 = new HashMap<String, Object>();
		map8.put("COD_OBJETO", "456");
		map8.put("SGL_UF", "CE");
		map8.put("DES_UF", "CEARA");
		
		Map<String, Object> map9 = new HashMap<String, Object>();
		map9.put("COD_OBJETO", "789");
		map9.put("SGL_UF", "AC");
		map9.put("DES_UF", "ACRE");
		
		List<Map<String,Object>> lista3 = new ArrayList<Map<String,Object>>();
		lista3.add(map7);
		lista3.add(map8);
		lista3.add(map9);
		
		consultas = new HashMap<ConsultaEmail, List<Map<String,Object>>>();
		consultas.put(c1, lista1);
		consultas.put(c2, lista2);
		consultas.put(c3, lista3);
	}

	private Tabela montarTabela() {
		Tabela tabela = new Tabela();
		Linha coluna = null;
		Linha linha = null;
		Celula celulaColuna = null;
		Celula celulaLinha = null;
		
		
		return tabela;
	}
	
	private NovaTabelaDinamica prepararTabelaDinamica() {
//		List<String> vals = null;
		List<String> colunas = new ArrayList<String>();
		List<List<String>> valores = new ArrayList<List<String>>();
		Map<String, List<String>> mapValores = new HashMap<String, List<String>>();
		NovaTabelaDinamica tabelaDinamica = new NovaTabelaDinamica();
		
		for (ConsultaEmail consulta : disparadorEmailTasklet.getConsultas()) {
			for (Map.Entry<String, String> coluna : consulta.getColunasMap().entrySet()) {
				colunas.add(coluna.getValue());
			}
		}
		
		for (Map.Entry<ConsultaEmail, List<Map<String,Object>>> consulta : consultas.entrySet()) {
			for (Map<String,Object> registro : consulta.getValue()) {
				List<String> l = new ArrayList<String>();
				for (Map.Entry<String, Object> reg : registro.entrySet()) {
					/*vals = mapValores.get(reg.getKey());
					
					if (vals == null) {
						vals = new ArrayList<String>();
					}
					
					vals.add(reg.getValue().toString());
					
					mapValores.put(reg.getKey(), vals);*/
					l.add(reg.getValue().toString());
				}
				valores.add(l);
			}
		}
		
		/*for (Map.Entry<String, List<String>> val : mapValores.entrySet()) {
			valores.add(val.getValue());
		}*/
		
		tabelaDinamica.setColunas(colunas);
		tabelaDinamica.setValores(valores);
		
		mapModel.put("colunas", colunas);
		mapModel.put("linhas", valores);
		
		return tabelaDinamica;
	}
	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setFreeMarkerConfigurationFactory(FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactory) {
		this.freeMarkerConfigurationFactory = freeMarkerConfigurationFactory;
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

	public void setMaximoRegistrosPorConsulta(Integer maximoRegistrosPorConsulta) {
		this.maximoRegistrosPorConsulta = maximoRegistrosPorConsulta;
	}
	
}
