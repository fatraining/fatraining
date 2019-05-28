package jp.co.futureantiques.webapptraining.repository.bandTaneichi;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.webapptraining.model.bandTaneichi.BandMainTaneichi;

/**
 * BandMainリポジトリのインターフェース
 * @author future
 *
 */
public interface BandMainTaneichiRepository
		extends JpaRepository<BandMainTaneichi, Long>, JpaSpecificationExecutor<BandMainTaneichi> {

	/***
	 * 対象のレコード削除フラグを１にする
	 *
	 * @param long id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE BandMainTaneichi SET delFlg = 1 WHERE id = :id")
	void delete(@Param("id") final long id);

	/**
	 * 対象のレコードを削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM BandMainTaneichi WHERE id IN(:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);

}
