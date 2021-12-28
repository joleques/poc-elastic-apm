package com.pocs.nometimeservice.controller;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocs.nometimeservice.repositorio.TimeRepositorio;

import net.logstash.logback.argument.StructuredArguments;

@RestController
@RequestMapping("/nome")
public class NomeController {

	Logger LOGGER = getLogger(NomeController.class);
	
	@Autowired
	private TimeRepositorio timeRepositorio;
	
	@GetMapping("/time/{codigoTime}")
	public ApiResult getNomeTime(@PathVariable Long codigoTime) {
		Header header = new Header(codigoTime, "nome-service");
		
		try {
			String nome = timeRepositorio.getNome(codigoTime);
			if (nome == null)
				return ApiResult.erro();

			LOGGER.info(String.format("Nome %s retornado com sucesso.", nome), StructuredArguments.keyValue("header", header));
			
			return ApiResult.sucesso(nome);
		}catch (Exception e) {

			LOGGER.error(String.format("Problemas a buscar a nome : %s", e.getMessage()), StructuredArguments.keyValue("header", header));
			
			return ApiResult.erro();
		}
	}
}
