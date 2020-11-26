package br.com.produto.controller.request;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoRequest {
	
	
	private Integer id;
	
	
	@NotBlank(message = "Nome é um campo obrigatório e não deve ser nullo")
	private String nome;
	
	@Min(value = 0, message = "Quantidade não pode ser NULO deve receber pelomenos 0(ZERRO)")
	private long quantidade;
	
	
	@Min(value = 0, message = "Preço é um campo obrigatório caso nao tenha um preço coloque 0")
	@NotNull(message = "Preco é um campo obrigatório e não deve ser nullo")
	private Double preco;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public long getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
