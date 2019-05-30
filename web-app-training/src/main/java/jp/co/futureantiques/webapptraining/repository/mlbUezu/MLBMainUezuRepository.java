package jp.co.futureantiques.webapptraining.repository.mlbUezu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.webapptraining.model.mlbUezu.MlbMainUezu;

/** MLBMainUezuリポジトリのインターフェース */

public interface MLBMainUezuRepository extends JpaRepository<MlbMainUezu, Long>, JpaSpecificationExecutor<MlbMainUezu> {

	/** 対象のレコードの削除フラグを1にする */
	@Transactional
	@Modifying
	@Query("UPDATE MlbMainUezu SET delFlg = 1 WHERE id = :id")
	void delete(@Param("id") final long id);

	//未作成↓
	/** 対象のレコードを削除する
	@Transactional
	@Modifying
	@Query("DELETE FROM MovieMain WHERE id IN(:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);
	*/
}