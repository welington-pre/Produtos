package br.com.produto.model;

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

@Entity
public class Produto {
	
	 private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	@NotBlank(message = "Nome é um campo obrigatório e não deve ser nullo")
	private String nome;
	
	@Min(value = 0, message = "Quantidade não pode ser NULO deve receber pelomenos 0(ZERRO)")
	private long quantidade;
	
	@Column(nullable = false)
	@Min(value = 0, message = "Preço é um campo obrigatório caso nao tenha um preço coloque 0")
	@NotNull(message = "Preco é um campo obrigatório e não deve ser nullo")
	private Double preco;
	
	
	
	public Produto() {
		
	}

	public Produto(String nome, long quantidade, Double preco) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}

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
