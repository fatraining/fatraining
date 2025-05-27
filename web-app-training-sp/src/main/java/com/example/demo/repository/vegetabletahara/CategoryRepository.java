package com.example.demo.repository.vegetabletahara;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.vegetabletahara.CategoryTahara;

/**
 * CategoryTaharaリポジトリのインターフェース
 *
 * @author future
 */
public interface CategoryRepository extends JpaRepository<CategoryTahara, Integer>{

}
