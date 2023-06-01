package jp.co.futureantiques.webapptraining.repository.kpoptateishi;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.webapptraining.model.kpoptateishi.KpopMain;

/**
 * KpopMainリポジトリのインターフェース
 *
 * @author future
 */
public interface KpopMainRepository extends JpaRepository<KpopMain, Long>, JpaSpecificationExecutor<KpopMain> {

	/**
	 * 対象のレコードの削除フラグを1にする
	 *
	 * @param long id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE KpopMain SET delFlg = 1 WHERE id = :id")
	void delete(@Param("id") final long id);

	/**
	 * 対象のレコードを削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM KpopMain WHERE id IN(:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);

	// 削除画面追加機能
	/**
	 * 対象のレコードの削除フラグを0にする
	 *
	 * @param long id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE KpopMain SET delFlg = 0 WHERE id = :id")
	void restore(@Param("id") final long id);
}
