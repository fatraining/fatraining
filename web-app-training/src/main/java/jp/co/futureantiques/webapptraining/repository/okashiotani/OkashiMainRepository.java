package jp.co.futureantiques.webapptraining.repository.okashiotani;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.webapptraining.model.okashiotani.OkashiMainOtani;

/**
 * OkashiMainリポジトリのインターフェース
 *
 * @author future
 */
public interface OkashiMainRepository extends JpaRepository<OkashiMainOtani, Long>,JpaSpecificationExecutor<OkashiMainOtani>{

	/**
	 * 対象のレコードの削除フラグを1にする
	 *
	 * @param long id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE OkashiMainOtani SET delFlg = 1 ,update_date=now() WHERE id = :id")
	void delete(@Param("id") final long id);

	/**
	 * 対象のレコードを削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM OkashiMainOtani WHERE id IN(:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);
}
