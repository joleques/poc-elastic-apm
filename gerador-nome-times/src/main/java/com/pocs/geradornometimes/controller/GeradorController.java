package com.pocs.geradornometimes.controller;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocs.geradornometimes.repositorio.GeradorRepositorio;

import net.logstash.logback.argument.StructuredArguments;


@RestController
@RequestMapping("/gerador")
public class GeradorController {

	Logger LOGGER = getLogger(GeradorController.class);
	
	@Autowired
	private GeradorRepositorio cidadeRepositorio;
	
	@GetMapping("/nome-time/{codigoTime}")
	public ApiResult getNomeTime(@PathVariable Long codigoTime) {
		Header header = new Header(codigoTime, "gerador-service");
		
		try {
			String nome = cidadeRepositorio.getNome(codigoTime);
			if (nome == null)
				throw new RuntimeException("Nome não encontrado!!!");

			LOGGER.info(String.format("Detalhes %s retornado com sucesso", nome), StructuredArguments.keyValue("header", header));
			
			return ApiResult.sucesso(nome);
		}catch (Exception e) {

			LOGGER.error(String.format("Problemas a buscar a nome : %s", e.getMessage()), StructuredArguments.keyValue("header", header));
			
			return ApiResult.erro();
		}
	}
}
