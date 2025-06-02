package com.example.demo.repository.pokemon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.pokemon.Type1Satoyoshi;

/**
 * Type1リポジトリのインターフェース
 *
 * @author satoyoshi
 */
public interface Type1SatoyoshiRepository extends JpaRepository<Type1Satoyoshi, Integer> {
}
