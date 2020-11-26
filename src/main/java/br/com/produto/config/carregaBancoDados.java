package br.com.produto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.produto.model.Produto;
import br.com.produto.repository.ProdutoRepository;

@Configuration
@Profile("dev")
public class carregaBancoDados {

	@Autowired
	private ProdutoRepository repository;
	
	@Bean
	CommandLineRunner carregaBD() {
		return args -> {
			Produto p1 = new Produto("placa mae", 50, 599.90);
			Produto p2 = new Produto("processador", 20, 999.90);
			
			repository.save(p1);
			repository.save(p2);
			
		};
	}
}
