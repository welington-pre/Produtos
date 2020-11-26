package br.com.produto;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProdutoApplication {

//	http://localhost:8081/loja/h2-console
//	http://localhost:8081/loja/produto
//	http://localhost:8081/loja/swagger-ui.html
	
	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
		
		System.out.println("\nSERVIDOR ONLINE\n");
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
