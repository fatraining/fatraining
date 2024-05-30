package com.example.demo.repository.game;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.game.GameEvaluationToho;

/**
 * GameEvaluationTohoリポジトリのインターフェース
 *
 * @author future
 */

public interface GameEvaluationTohoRepository extends JpaRepository<GameEvaluationToho, Integer> {
}
