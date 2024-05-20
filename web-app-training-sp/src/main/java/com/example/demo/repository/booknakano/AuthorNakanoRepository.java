package com.example.demo.repository.booknakano;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.booknakano.AuthorNakano;

/**
 * Authorリポジトリのインターフェース
 *
 * @author future
 */
public interface AuthorNakanoRepository extends JpaRepository<AuthorNakano, Integer> {
}