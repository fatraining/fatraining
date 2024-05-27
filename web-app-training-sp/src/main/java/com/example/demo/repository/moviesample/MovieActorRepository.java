package com.example.demo.repository.moviesample;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.moviesample.MovieActor;

/**
 * MovieActorリポジトリのインターフェース
 *
 * @author future
 */
public interface MovieActorRepository extends JpaRepository<MovieActor, Integer> {
}