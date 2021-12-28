package com.pocs.geradornometimes.controller;

public class ApiResult {

	private int status;
	
	private String nome;
	
	private ApiResult(int status, String nome) {
		super();
		this.status = status;
		this.nome = nome;
	}


	public static ApiResult erro() {
		return new ApiResult(400, null);
	}


	public static ApiResult sucesso(String nome) {
		return new ApiResult(200, nome);
	}


	public int getStatus() {
		return status;
	}


	public String getNome() {
		return nome;
	}
	
	
}
