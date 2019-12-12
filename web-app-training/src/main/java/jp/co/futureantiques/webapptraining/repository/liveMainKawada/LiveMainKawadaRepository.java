package jp.co.futureantiques.webapptraining.repository.liveMainKawada;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.webapptraining.model.liveMainKawada.LiveMainKawada;

/**
 * LiveMainKawadaリポジトリのインターフェース
 * @author future
 *
 */

public interface LiveMainKawadaRepository
		extends JpaRepository<LiveMainKawada, Long>, JpaSpecificationExecutor<LiveMainKawada> {

	/**
	 * 対象レコードの削除フラグを１にする
	 * @param long id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE LiveMainKawada SET delFlg = 1 WHERE id = :id")
	void delete(@Param("id") final long id);

	/**
	 * 対象のレコードを削除する
	 * @param ArrayList<Long> ids
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM LiveMainKawada WHERE id IN(:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);

}
