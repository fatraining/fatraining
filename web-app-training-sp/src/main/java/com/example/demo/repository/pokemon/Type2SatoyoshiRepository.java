package com.example.demo.repository.pokemon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.pokemon.Type2Satoyoshi;

/**
 * Type2リポジトリのインターフェース
 *
 * @author satoyoshi
 */
public interface Type2SatoyoshiRepository extends JpaRepository<Type2Satoyoshi, Integer> {
}
