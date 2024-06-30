package com.aluracursos.challenge.literatura;

import com.aluracursos.challenge.literatura.principal.Principal;
import com.aluracursos.challenge.literatura.repository.IAuthorRepository;
import com.aluracursos.challenge.literatura.repository.IBookRepository;
import com.aluracursos.challenge.literatura.services.API;
import com.aluracursos.challenge.literatura.services.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {

	@Autowired
	private IBookRepository bookRepository;

	@Autowired
	private IAuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal("https://gutendex.com/books/", new API(), new Converter(), bookRepository, authorRepository);
		principal.menu();
	}
}
