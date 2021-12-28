package com.pocs.nometimeservice.controller;

public class Header {

	private Long id;
	
	private String servico;

	public Header(Long id, String servico) {
		super();
		this.id = id;
		this.servico = servico;
	}

	public Long getId() {
		return id;
	}

	public String getServico() {
		return servico;
	}
}
