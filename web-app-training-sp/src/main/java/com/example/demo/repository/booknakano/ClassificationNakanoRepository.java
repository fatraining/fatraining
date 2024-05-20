package com.example.demo.repository.booknakano;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.booknakano.ClassificationNakano;

/**
 * Classificationリポジトリのインターフェース
 *
 * @author future
 */
public interface ClassificationNakanoRepository extends JpaRepository<ClassificationNakano, Integer> {
}