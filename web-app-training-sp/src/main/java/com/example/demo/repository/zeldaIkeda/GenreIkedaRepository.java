package com.example.demo.repository.zeldaIkeda;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.zeldaikeda.GenreIkeda;

/**
 * GenreIkedaリポジトリのインターフェース
 */
public interface GenreIkedaRepository extends JpaRepository<GenreIkeda, Integer> {
}
