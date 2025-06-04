package com.example.demo.repository.pokemon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.pokemon.AppearanceSatoyoshi;

/**
 * Appearanceリポジトリのインターフェース
 *
 * @author satoyoshi
 */
public interface AppearanceSatoyoshiRepository extends JpaRepository<AppearanceSatoyoshi, Integer> {
}