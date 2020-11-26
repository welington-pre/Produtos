package br.com.produto.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.produto.model.Produto;
import br.com.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	
	public List<Produto> todos() {
		return repository.findAll();
	}
	
	public Produto getProduto(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}
	
	public Produto salva(Produto produto) {
		return repository.save(produto);
	}
	
	public Produto altera(Integer id, Produto produto) {
		Produto produtoBanco = getProduto(id);
		
		produtoBanco.setNome(produto.getNome());
		produtoBanco.setQuantidade(produto.getQuantidade());
		produtoBanco.setPreco(produto.getPreco());
		
		return salva(produtoBanco);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Optional<Produto> filtrar(String type, String pesq) {
		
		Optional<Produto> produtos = null;
		
		if(type.equals("id")) {
			produtos = repository.findById(Integer.valueOf(pesq));
		}
		
		if(type.equals("nome")) {
			produtos = repository.findByNome(pesq);
		}
		
		if(type.equals("quantidade")) {
			produtos = repository.findByQuantidade(Long.valueOf(pesq));
		}
		
		if(type.equals("preco")) {
			produtos = repository.findByPreco(Double.valueOf(pesq));
		}
		
		return produtos;
		
	}
	
}
