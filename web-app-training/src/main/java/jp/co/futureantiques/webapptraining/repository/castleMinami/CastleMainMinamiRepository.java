package jp.co.futureantiques.webapptraining.repository.castleMinami;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.webapptraining.model.castleMinami.CastleMainMinami;

/**
 * CastleMainのリポジトリのインターフェース
 *
 * @author Minami
 *
 */
public interface CastleMainMinamiRepository extends JpaRepository<CastleMainMinami, Long>,JpaSpecificationExecutor<CastleMainMinami> {

	/**
	 * 対象レコードの削除フラグを1にする
	 * @param long id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE CastleMainMinami SET delFlg=1 WHERE id= :id")
	void delete(@Param("id") final long id);

}
