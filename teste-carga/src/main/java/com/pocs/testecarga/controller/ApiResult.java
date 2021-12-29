package com.pocs.testecarga.controller;

public class ApiResult {

	private int status;
	
	private String message;
	
	private ApiResult(int status, String nome) {
		super();
		this.status = status;
		this.message = nome;
	}


	public static ApiResult erro() {
		return new ApiResult(400, null);
	}


	public static ApiResult sucesso(String message) {
		return new ApiResult(200, message);
	}


	public int getStatus() {
		return status;
	}


	public String getMessage() {
		return message;
	}
	
	
}
