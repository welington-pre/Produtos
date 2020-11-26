package br.com.produto.controller.response;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import br.com.produto.model.Produto;

public class ProdutoResponse {
	
	
	private Produto produto;
	
	

	public ProdutoResponse(Produto produto) {
		super();
		this.produto = produto;
	}

	public Integer getId() {
		return produto.getId();
	}

	public String getNome() {
		return produto.getNome();
	}

	public long getQuantidade() {
		return produto.getQuantidade();
	}

	public Double getPreco() {
		return produto.getPreco();
	}
	
}
