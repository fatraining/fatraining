package jp.co.futureantiques.webapptraining.repository.crKawanaka;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.futureantiques.webapptraining.model.crKawanaka.CrMainKawanaka;

/*
 * CrMainKawanakaリポジトリのインターフェース
 * @authour Misato Kawanaka
 */
public interface CrMainKawanakaRepository
		extends JpaRepository<CrMainKawanaka, Long>, JpaSpecificationExecutor<CrMainKawanaka> {

	/*
	 * 対象レコードの削除フラグを1にする
	 * @param long id
	 */

	@Transactional
	@Modifying
	@Query("update CrMainKawanaka set delFlg=1 where id=:id")
	void delete(@Param("id") final long id);

	/*
	 * 対象のレコードを削除する
	 * @Param ArrayList<Long> ids
	 */

	@Transactional
	@Modifying
	@Query("delete from CrMainKawanaka where id in (:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);
}
