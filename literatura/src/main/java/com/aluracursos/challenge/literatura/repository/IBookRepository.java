package com.aluracursos.challenge.literatura.repository;


import com.aluracursos.challenge.literatura.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository <Book, Long> {
}


