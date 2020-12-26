package br.com.produto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.produto.controller.request.ProdutoRequest;
import br.com.produto.controller.response.ProdutoResponse;
import br.com.produto.model.Produto;
import br.com.produto.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/produto")
@Validated
@Api(value="Cadastro de Produtos")
@CrossOrigin(origins="*")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	@ApiOperation(value = "Retorna uma lista de produtos")
	public List<ProdutoResponse> todos() {
		List<Produto> produto = service.todos();
		
		List<ProdutoResponse> produtoRespose = produto
				.stream()
				.map((produtoMap) ->{
					return new ProdutoResponse(produtoMap);
				}).collect(Collectors.toList());
		
		return produtoRespose;
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um produto")
	public Produto getProduto(@PathVariable Integer id) {
		return service.getProduto(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "grava um produto no banco de dados")
	public ProdutoResponse salvar(@RequestBody @Valid ProdutoRequest produtoRequest) {
		Produto produto = mapper.map(produtoRequest, Produto.class);
		
		Produto produtoSalvo = service.salva(produto);
		return new ProdutoResponse(produtoSalvo);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Altera um produto no banco de dados")
	public ProdutoResponse alterar(@PathVariable Integer id, @RequestBody @Valid ProdutoRequest produtoRequest) {
		Produto produto = mapper.map(produtoRequest, Produto.class);
		
		Produto produtoAlterado = service.altera(id, produto);
		return new ProdutoResponse(produtoAlterado);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Deleta um produto no banco de dados")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@GetMapping("/filtro")
	public Optional<Produto> filtro(
			@RequestParam(value = "fType", required = false) String type,
			@RequestParam(value = "fPesq", required = false)String pesq
			) {
		
		Optional<Produto> produtos = service.filtrar(type, pesq);
	
		return produtos;
		
	}
	
}
