package com.pocs.testecarga.repositorio;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Random;

import static org.slf4j.LoggerFactory.getLogger;

@Repository
public class GeradorService {

	Logger LOGGER = getLogger(GeradorService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${generator.gerador-host}")
	private String geradorHost;

	@Value("${generator.gerador-PORT}")
	private String geradorPort;

	@Async
	public void executeTest() {
		int count = 0;
		while (true){
			try {
				int codigoTime = new Random().nextInt(6);
				ResponseEntity<ResultResponse> time = restTemplate.getForEntity(new URI(getEndpointNomeTime().concat(String.valueOf(codigoTime))), ResultResponse.class);
				LOGGER.info(String.format("Codigo: %d - Resultado: %s", codigoTime, time.getBody().getNome() != null ? time.getBody().getNome() : " Codigo invalido"));
				if (count % 5 == 0)
					Thread.sleep(1000);
				count++;
			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
				throw new RuntimeException(e);
			}
		}
	}

	private String getEndpointNomeTime() {
		return this.geradorHost.concat(":").concat(this.geradorPort).concat("/gerador/nome-time/");
	}


}
