package com.example.demo.repository.booknakano;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.booknakano.CharacterOrthographyNakano;

/**
 * CharacterOrthographyリポジトリのインターフェース
 *
 * @author future
 */
public interface CharacterOrthographyNakanoRepository extends JpaRepository<CharacterOrthographyNakano, Integer> {
}