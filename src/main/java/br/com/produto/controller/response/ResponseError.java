package br.com.produto.controller.response;

import java.util.List;

public class ResponseError {

	private List<String> erros;

	public ResponseError(List<String> erros) {
		super();
		this.erros = erros;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
	
}
