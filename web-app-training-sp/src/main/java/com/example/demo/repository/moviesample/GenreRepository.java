package com.example.demo.repository.moviesample;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.moviesample.Genre;

/**
 * Genreリポジトリのインターフェース
 *
 * @author future
 */
public interface GenreRepository extends JpaRepository<Genre, Long> {
}