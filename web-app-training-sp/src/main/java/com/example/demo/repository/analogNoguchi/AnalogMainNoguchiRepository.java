package com.example.demo.repository.analogNoguchi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.analogNoguchi.AnalogMainNoguchi;

/**
 * AnalogMainリポジトリのインターフェース
 *
 * @author future
 */
public interface AnalogMainNoguchiRepository
		extends JpaRepository<AnalogMainNoguchi, Long>, JpaSpecificationExecutor<AnalogMainNoguchi> {

	/**
	 * メインテーブルから削除フラグが 0 のレコードの対象年齢（targetYears）を重複なしで取得する。
	 *  
	 * @return 対象年齢の一覧
	 */
	@Query("SELECT DISTINCT a.targetYears FROM AnalogMainNoguchi a WHERE a.delFlg='0' ORDER BY a.targetYears")
	List<Integer> findDistinctTargetYears();

	/**
	 * 対象のレコードの削除フラグを1にする
	 * 
	 * @param long id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE AnalogMainNoguchi SET delFlg = '1' WHERE id = :id")
	void delete(@Param("id") final long id);

	/**
	 * 対象レコードを削除する
	 * 
	 * @param ArrayList<Long> ids
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM AnalogMainNoguchi WHERE id IN(:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);
}
