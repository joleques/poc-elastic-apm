package com.pocs.nometimeservice.repositorio;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class TimeRepositorio {

	private Map<Long, String> times;

	public TimeRepositorio() {
		times = new HashMap<Long, String>();
		times.put(1L, "Internacional");
		times.put(2L, "Palmeiras");
		times.put(3L, "Flamengo");
		times.put(4L, "Cruzeiro");
		times.put(5L, "Londrina");
	}
	
	public String getNome(Long codigoTime) {
		return times.get(codigoTime);
	}
	
	
}
