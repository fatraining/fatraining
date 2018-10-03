package jp.co.futureantiques.webapptraining.repository.heritageKataoka;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.futureantiques.webapptraining.model.heritagekataoka.HeritageMainKataoka;

/**
 * HeritageMainリポジトリのインターフェース
 *
 * @author MIKI KATAOKA
 *
 */

@Repository
public interface HeritageMainKataokaRepository extends JpaRepository<HeritageMainKataoka, Long>, JpaSpecificationExecutor<HeritageMainKataoka>{
	/**
	 * 対象のレコードの削除フラグを1にする
	 *
	 * @param long id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE HeritageMainKataoka SET delFlg = 1 WHERE id = :id")
	void delete(@Param("id") final long id);

	/**
	 * 対象のレコードを削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM HeritageMainKataoka WHERE id IN(:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);

}




