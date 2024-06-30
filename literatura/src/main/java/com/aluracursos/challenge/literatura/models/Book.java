package com.aluracursos.challenge.literatura.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private int idBook;

    @Column(unique = true)
    private String title;

    @ManyToOne (cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Author author = new Author();

    @ElementCollection
    private List<String> subjects = new ArrayList<>();

    @ElementCollection
    private List<String> bookshelves = new ArrayList<>();

    @ElementCollection
    private List<String> languages = new ArrayList<>();

    private boolean copyright;
    private Long downloadCount;

    public Book() {}

    public Book(DataBook dataBook) {
        this.idBook = dataBook.idBook();
        this.title = dataBook.title();
        this.subjects = List.of(dataBook.subjects());
        this.bookshelves = List.of(dataBook.bookshelves());
        this.languages = List.of(dataBook.languages());
        this.copyright = dataBook.copyright();
        this.downloadCount = dataBook.downloadCount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdBook() {
        return idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(List<String> bookshelves) {
        this.bookshelves = bookshelves;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public boolean getCopyright() {
        return copyright;
    }

    public void setCopyright(boolean copyright) {
        this.copyright = copyright;
    }

    public Long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Long downloadCount) {
        this.downloadCount = downloadCount;
    }
}
