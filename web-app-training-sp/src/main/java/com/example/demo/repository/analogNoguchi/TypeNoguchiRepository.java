package com.example.demo.repository.analogNoguchi;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.analogNoguchi.TypeNoguchi;

/**
 * Typeリポジトリのインターフェース
 *
 * @author future
 */
public interface TypeNoguchiRepository extends JpaRepository<TypeNoguchi, Integer> {

}
