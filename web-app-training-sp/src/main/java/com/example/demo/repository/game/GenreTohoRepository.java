package com.example.demo.repository.game;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.game.GenreToho;

/**
 * Genreリポジトリのインターフェース
 *
 * @author future
 */

public interface GenreTohoRepository extends JpaRepository<GenreToho, Integer>{

}