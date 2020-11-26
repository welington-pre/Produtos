package br.com.produto.repository;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import br.com.produto.model.Produto;

@SpringBootTest
public class ProdutoRepositoryTest {
	
	@Autowired
	private ProdutoRepository repository;
	
	
	@Test
	void findByExample() {
	}
}
