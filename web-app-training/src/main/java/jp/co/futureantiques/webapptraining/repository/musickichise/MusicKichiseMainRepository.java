package jp.co.futureantiques.webapptraining.repository.musickichise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.webapptraining.model.musickichise.MusicKichiseMain;

/**
 * MusicKichiseMainリポジトリのインターフェース
 * @author future
 *
 */
public interface MusicKichiseMainRepository
		extends JpaRepository<MusicKichiseMain, Long>, JpaSpecificationExecutor<MusicKichiseMain> {

	/**
	 * 対象のレコードの削除フラグを1にする
	 * @param id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE MusicKichiseMain SET delFlg = 1 WHERE id = :id")
	void delete(@Param("id") final long id);
}