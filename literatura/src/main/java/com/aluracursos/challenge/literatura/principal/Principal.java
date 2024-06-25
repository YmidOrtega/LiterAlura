package com.aluracursos.challenge.literatura.principal;

import com.aluracursos.challenge.literatura.models.*;
import com.aluracursos.challenge.literatura.repository.IBookRepository;
import com.aluracursos.challenge.literatura.services.API;
import com.aluracursos.challenge.literatura.services.Converter;


import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class  Principal {

    private final Scanner input = new Scanner(System.in);
    private final API api;
    private final String urlbase;
    private final IBookRepository repository;
    private final Converter converter;
    private List<Book> history = new ArrayList<>();

    public Principal(String urlbase, API api, Converter converter ,IBookRepository bookRepository) {
        this.urlbase = urlbase;
        this.api = api;
        this.repository = bookRepository;
        this.converter = converter;
    }


    public void menu() throws IOException, InterruptedException {
        var option = 0;
        while (option != 6) {
            System.out.println("""
                    ¡Bienvenido a la literatura!
                                    
                    1. Buscar libro por su nombre
                    2. Historial de libros buscados
                    3. Autores registrados
                    4. Buscar autores registrados por un año determinado
                    5. Libros por idioma
                                    
                    6. Salir del programa
                    """);
            option = input.nextByte();
            input.nextLine();

            switch (option) {
                case 1: searchBook();
                    break;
                case 2: searchHistory();
                    break;
                case 3: //searchAuthors();
                    break;
                case 4: System.out.println("Ingrese el año: ");
                    int year = input.nextInt();
                    //searchAuthorsByYear(year);
                    break;
                case 5:
                    System.out.println("Ingrese el idioma: ");
                    String language = input.nextLine();
                    //searchBooksByLanguage(language);
                    break;
                case 6:
                    System.out.println("Cerranndo programa... ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }

    private DataBook apiRequest() {
        System.out.println("Ingrese el nombre del libro: ");
        var bookName = input.nextLine();
        var url = urlbase + "?search=" + URLEncoder.encode(bookName, StandardCharsets.UTF_8);
        api.consumeAPI(url);
        //return converter.obtenerDatos(api.getJson(), DataResults.class).results().get(0);
        DataResults dataResults = converter.obtenerDatos(api.getJson(), DataResults.class);
        if (dataResults.results().size() == 1) {
            return dataResults.results().get(0);
        }else if (dataResults.results().size() > 1) {
            System.out.println("\nSe encontraron " + dataResults.count() + " libros");
            System.out.println("\nElige uno de los siguientes libros: \n");
            for (int i = 0; i < dataResults.results().size(); i++) {
                System.out.println(i + ". " + dataResults.results().get(i).title());
            }
            var option = input.nextInt();
            return dataResults.results().get(option);

        }
        return null;
    }

    private void searchHistory() {
        if (history.isEmpty()) {
            System.out.println("\nNo se ha buscado ningún libro\n");
        } else {
            System.out.println("\nHistorial de libros buscados: \n");
            for (int i = 0; i < history.size(); i++) {
                System.out.println(i + ". " + history.get(i).getTitle());
            }

        }

    }

    private void searchBook () {
        DataBook dataBook = apiRequest();
        Book book = new Book(dataBook);
        book.setAuthor(new Author(new DataAuthor(dataBook.author().get(0).name(),
                dataBook.author().get(0).birthYear(),
                dataBook.author().get(0).deathYear())));
        repository.save(book);
        history.add(book);
        System.out.println("\nLibro encontrado: " + book.getTitle() + "\n");
    }
}


