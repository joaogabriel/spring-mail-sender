<!DOCTYPE html>
<html lang="en" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;position:relative;min-height:100%;font-family:sans-serif;-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%;font-size:62.5%;-webkit-tap-highlight-color:rgba(0,0,0,0);" >
	<head style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;" >
		<meta charset="utf-8" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;" >
		<meta http-equiv="X-UA-Compatible" content="IE=edge" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;" >
		<meta name="viewport" content="width=device-width, initial-scale=1" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;" >
		<title style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;" >Mail Template</title>
	</head>
	
	<body style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;margin-top:0;margin-bottom:0;margin-right:0;margin-left:0;font-family:'Helvetica Neue',Helvetica,Arial,sans-serif;font-size:14px;line-height:1.42857143;color:#333;background-color:#fff;" >
		<div class="container" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;width:auto;max-width:680px;padding-top:0;padding-bottom:0;margin-right:auto;margin-left:auto;padding-left:15px;padding-right:15px;" >
			<div class="page-header" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;padding-bottom:9px;margin-top:40px;margin-bottom:20px;margin-right:0;margin-left:0;border-bottom-width:1px;border-bottom-style:solid;border-bottom-color:#eee;" >
				<h1 style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;margin-right:0;margin-left:0;font-family:inherit;font-weight:500;line-height:1.1;color:inherit;margin-top:20px;margin-bottom:10px;font-size:36px;" >Procbatch<small style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;font-weight:400;line-height:1;color:#999;font-size:65%;" > ${titulo}</small></h1>
			</div>
			
			<p class="lead" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;margin-top:0;margin-right:0;margin-left:0;margin-bottom:20px;font-size:16px;font-weight:200;line-height:1.4;" >${resumo}</p>
			
			<!-- http://viralpatel.net/blogs/spring-mvc-freemarker-ftl-example/ -->
			
			<#list nomes as nome>
        		${nome}
			</#list>
		    
			<#list mapa?keys as key>
				${key}
			</#list>
			
			<#include "template-outlook2007-tabela.ftl">
			
			<div align="center" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;" >
				<ol class="breadcrumb" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;margin-top:0;padding-top:8px;padding-bottom:8px;padding-right:15px;padding-left:15px;margin-bottom:20px;list-style-type:none;list-style-position:outside;list-style-image:none;background-color:#f5f5f5;border-radius:4px;" >
					<a href="http://procbatch-01.cad.apps.tse.jus.br:8080/procbatch/" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;background-color:transparent;background-image:none;background-repeat:repeat;background-position:0 0;background-attachment:scroll;color:#428bca;text-decoration:none;" >Acessar o Sistema</a> | 
					<a href="mailto:secad@tse.jus.br" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;background-color:transparent;background-image:none;background-repeat:repeat;background-position:0 0;background-attachment:scroll;color:#428bca;text-decoration:none;" >Reportar Problema</a>
				</ol>
				
				&nbsp;
				
				<ol class="breadcrumb" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;margin-top:0;padding-top:8px;padding-bottom:8px;padding-right:15px;padding-left:15px;margin-bottom:20px;list-style-type:none;list-style-position:outside;list-style-image:none;background-color:#f5f5f5;border-radius:4px;" >
					<a href="http://sticonhecimento.tse.jus.br/" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;background-color:transparent;background-image:none;background-repeat:repeat;background-position:0 0;background-attachment:scroll;color:#428bca;text-decoration:none;" >STI</a> /
					<a href="http://sticonhecimento.tse.jus.br/csele" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;background-color:transparent;background-image:none;background-repeat:repeat;background-position:0 0;background-attachment:scroll;color:#428bca;text-decoration:none;" >CSELE</a> /
					<a href="http://sticonhecimento.tse.jus.br/csele/secad" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;background-color:transparent;background-image:none;background-repeat:repeat;background-position:0 0;background-attachment:scroll;color:#428bca;text-decoration:none;" >SECAD</a>
				</ol>
				
				<span class="label label-success" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;display:inline;padding-top:.2em;padding-bottom:.3em;padding-right:.6em;padding-left:.6em;font-size:75%;font-weight:700;line-height:1;color:#fff;text-align:center;white-space:nowrap;vertical-align:baseline;border-radius:.25em;background-color:#5cb85c;" >Mensagem gerada às ${horarioEnvio} do dia ${dataEnvio}.</span>
				<br style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;" />
				<span class="label label-warning" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;display:inline;padding-top:.2em;padding-bottom:.3em;padding-right:.6em;padding-left:.6em;font-size:75%;font-weight:700;line-height:1;color:#fff;text-align:center;white-space:nowrap;vertical-align:baseline;border-radius:.25em;background-color:#f0ad4e;" >${nomeHostServidor} - ${enderecoIPServidor}</span>
				<br style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;" />
				<span class="label label-danger" style="-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;display:inline;padding-top:.2em;padding-bottom:.3em;padding-right:.6em;padding-left:.6em;font-size:75%;font-weight:700;line-height:1;color:#fff;text-align:center;white-space:nowrap;vertical-align:baseline;border-radius:.25em;background-color:#d9534f;" >Ambiente: ${ambiente}</span>
			</div>
		</div>
	</body>
</html>