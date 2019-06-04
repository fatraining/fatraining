package jp.co.futureantiques.webapptraining.repository.guiterFujimoto;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.GuiterMainFujimoto;

/**
 * GuiterMainFujimotoレポジトリのインターフェース
 *
 * @author future　FUJIMOTO
 *
 */

public interface GuiterMainFujimotoRepository extends
		JpaRepository<GuiterMainFujimoto, Long>, JpaSpecificationExecutor<GuiterMainFujimoto> {

	/**
	 * 対象のレコードの削除フラグを1にする
	 *
	 * @param long id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE GuiterMainFujimoto SET delFlg = 1 WHERE id = :id")
	void delete(@Param("id") final long id);

	/**
	 * 対象のレコードの削除
	 * @param ArrayList<Long> ids
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM GuiterMainFujimoto WHERE id IN(:ids)")
	void deleteComp(@Param("ids")final ArrayList<Long> ids);

}