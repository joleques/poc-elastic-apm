package com.pocs.geradornometimes.repositorio;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Repository
public class GeradorRepositorio {
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${generator.name-host}")
	private String nameHost;

	@Value("${generator.name-PORT}")
	private String namePort;

	@Value("${generator.cidade-host}")
	private String cidadeHost;

	@Value("${generator.cidade-PORT}")
	private String cidadePort;

	public String getNome(Long codigoTime) {
		
		try {
			ResponseEntity<ResultResponse> time = restTemplate.getForEntity(new URI(getEndpointNomeTime().concat(String.valueOf(codigoTime))), ResultResponse.class);
			
			ResponseEntity<ResultResponse> cidade = restTemplate.getForEntity(new URI(getEndpointCidade().concat(String.valueOf(codigoTime))), ResultResponse.class);
			
			return time.getBody().getNome().concat(" de ").concat(cidade.getBody().getNome());
		} catch (RestClientException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}

	private String getEndpointCidade() {
		return this.cidadeHost.concat(":").concat(this.cidadePort).concat("/nome/cidade/");
	}

	private String getEndpointNomeTime() {
		return this.nameHost.concat(":").concat(this.namePort).concat("/nome/time/");
	}


}
