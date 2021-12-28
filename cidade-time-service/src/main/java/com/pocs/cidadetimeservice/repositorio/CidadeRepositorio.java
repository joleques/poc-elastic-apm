package com.pocs.cidadetimeservice.repositorio;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class CidadeRepositorio {

	private Map<Long, String> times;

	public CidadeRepositorio() {
		times = new HashMap<Long, String>();
		times.put(1L, "Porto Alegre");
		times.put(2L, "São Paulo");
		times.put(3L, "Rio de Janeiro");
		times.put(4L, "Belo Horizonte");
	}
	
	public String getNome(Long codigoTime) {
		String cidade = times.get(codigoTime);
		
		if (cidade == null)
			throw new RuntimeException(String.format("Código %d invalido!", codigoTime));
		
		return cidade;
	}
	
	
}
