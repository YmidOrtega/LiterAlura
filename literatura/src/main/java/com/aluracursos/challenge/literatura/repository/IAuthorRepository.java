package com.aluracursos.challenge.literatura.repository;

import com.aluracursos.challenge.literatura.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a.name FROM Author a")
    List<String> autoresRegistrados();

    @Query("SELECT a FROM Author a WHERE a.name = :name")
    Author findByName(String name);

    @Query("SELECT a.name FROM Author a WHERE a.birthYear = :year")
    List<String> findByBirthYear(Integer year);

}
