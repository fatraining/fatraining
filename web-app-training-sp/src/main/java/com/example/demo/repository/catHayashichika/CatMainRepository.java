package com.example.demo.repository.catHayashichika;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.catHayashichika.CatMainHayashichika;

import jakarta.transaction.Transactional;

/**
 * CatMainのリポジトリインターフェース
 * @author future
 */
public interface CatMainRepository extends JpaRepository<CatMainHayashichika, Long>, JpaSpecificationExecutor<CatMainHayashichika> {

	/**
	 * 対象のレコードの削除フラグを１にする
	 * @param long id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE CatMainHayashichika SET delFlag='1' WHERE id=:id")
	void delete(@Param("id") final long id);

	/**
	 * 対象のレコードを削除する
	 * @param ArrayList<Long> ids
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM CatMainHayashichika WHERE id IN(:ids)")
	void deletecomp(@Param("ids") final ArrayList<Long> ids);

}
