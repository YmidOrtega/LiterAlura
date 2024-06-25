package com.aluracursos.challenge.literatura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBook(
        @JsonAlias("id") int idBook,
        @JsonAlias("title") String title,
        @JsonAlias("authors") List<DataAuthor> author,
        @JsonAlias("subjects") String[] subjects,
        @JsonAlias("bookshelves") String[] bookshelves,
        @JsonAlias("languages") String[] languages,
        @JsonAlias("copyright") boolean copyright,
        @JsonAlias("download_count") Long downloadCount
){
}
