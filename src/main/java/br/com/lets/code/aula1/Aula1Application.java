package br.com.lets.code.aula1;

import br.com.lets.code.aula1.model.Cliente;
import br.com.lets.code.aula1.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Aula1Application {

	public static void main(String[] args) {
		SpringApplication.run(Aula1Application.class, args);
	}

	@Bean
	public CommandLineRunner carregandoBanco(ClienteRepository clienteRepository) throws Exception{
		return (args) -> {
			Cliente clientePadrao = new Cliente();
			clientePadrao.setName("Ana");
			clientePadrao.setAge(22);
			clientePadrao.setEmail("ana22@gmail.com");
			clientePadrao.setNumber("619999999");

			clienteRepository.save(clientePadrao);

		};
	}

}
