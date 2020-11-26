package br.com.produto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.produto.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	public Optional<Produto> findByNome(String nome);
	
	public Optional<Produto> findByQuantidade(long quantidade);
	
	public Optional<Produto> findByPreco(Double preco);
	
}
