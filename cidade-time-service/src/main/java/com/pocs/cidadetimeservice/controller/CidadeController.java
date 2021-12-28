package com.pocs.cidadetimeservice.controller;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocs.cidadetimeservice.repositorio.CidadeRepositorio;

import net.logstash.logback.argument.StructuredArguments;


@RestController
@RequestMapping("/nome")
public class CidadeController {

	Logger LOGGER = getLogger(CidadeController.class);
	
	@Autowired
	private CidadeRepositorio cidadeRepositorio;
	
	@GetMapping("/cidade/{codigoTime}")
	public ApiResult getNomeTime(@PathVariable Long codigoTime) {
		Header header = new Header(codigoTime, "cidade-service");
		try {
			String nome = cidadeRepositorio.getNome(codigoTime);
			if (nome == null)
				return ApiResult.erro(); 
			
			LOGGER.info(String.format("Cidade %s retornada com sucesso.", nome), StructuredArguments.keyValue("header", header));
			
			return ApiResult.sucesso(nome);
		}catch (Exception e) {
			
			LOGGER.error(String.format("Problemas a buscar a cidade : %s", e.getMessage()), StructuredArguments.keyValue("header", header));
			
			return ApiResult.erro();
		}
	}
}
