package com.projeto.backend.orm.datajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DatajpaApplication {

	private static final Logger log = LoggerFactory.getLogger(DatajpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DatajpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClienteRepository repositorio) {
		return (args) -> {
			// Salvar clientes
			repositorio.save(new Cliente("Olavo", "Nunes"));
			repositorio.save(new Cliente("Bruna", "Alexandra"));
			repositorio.save(new Cliente("Robinson", "Nunes"));
			repositorio.save(new Cliente("Sirlene", "Tostes"));
			repositorio.save(new Cliente("Dory", "Brigo"));

			// Buscar todos os clientes
			log.info("Clientes encontrados com findAll():");
      		log.info("-------------------------------");
      		repositorio.findAll().forEach(cliente -> {
        	log.info(cliente.toString());
      		});
      		log.info("");

			// Busca um cliente individual por ID
			Cliente cliente = repositorio.findById(1L);
      		log.info("Cliente encontrado com findById(1L):");
      		log.info("--------------------------------");
      		log.info(cliente.toString());
      		log.info("");

			// Busca clientes pelo último nome
			log.info("Cliente encontrado com findByUltimoNome('Nunes'):");
      		log.info("--------------------------------------------");
      		repositorio.findByUltimoNome("Nunes").forEach(nunes -> {
        	log.info(nunes.toString());
      		});
      		log.info("");
		};	
	}
}
