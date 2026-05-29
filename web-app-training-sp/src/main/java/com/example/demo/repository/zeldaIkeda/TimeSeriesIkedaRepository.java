package com.example.demo.repository.zeldaIkeda;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.zeldaikeda.TimeSeriesIkeda;

/**
 * TimeSeriesIkedaリポジトリのインターフェース
 */
public interface TimeSeriesIkedaRepository extends JpaRepository<TimeSeriesIkeda, Integer> {
}
