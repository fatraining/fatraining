package jp.co.futureantiques.webapptraining.repository.yugiohOkugawa;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.webapptraining.model.yugiohOkugawa.YugiohMainOkugawa;

/** YugiohMainOkugawaリポジトリのインターフェース
 *
 * @author Okugawa
 * */

public interface YugiohMainOkugawaRepository
		extends JpaRepository<YugiohMainOkugawa, Long>,JpaSpecificationExecutor<YugiohMainOkugawa>{

	/**
	 * 対象のレコードフラグを1にする
	 *
	 * @param long id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE YugiohMainOkugawa SET delFlg = 1 WHERE id = :id")
	void delete(@Param("id")final long id);

	/**
	 * 対象のレコードを削除する
	 * @param ArrauList<Long> ids
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM YugiohMainOkugawa WHERE id IN(:ids)")
	void deleteComp(@Param("ids")final ArrayList<Long>ids);

}
