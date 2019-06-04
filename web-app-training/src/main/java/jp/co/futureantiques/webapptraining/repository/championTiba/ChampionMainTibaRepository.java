package jp.co.futureantiques.webapptraining.repository.championTiba;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.webapptraining.model.championTiba.ChampionMainTiba;

/** ChampionMainTibaリポジトリのインターフェース */

public interface ChampionMainTibaRepository extends JpaRepository<ChampionMainTiba, Long>, JpaSpecificationExecutor<ChampionMainTiba>{

	/** 対象のレコードの削除フラグを1にする */
	@Transactional
	@Modifying
	@Query("UPDATE ChampionMainTiba SET delFlg=1 WHERE id=:id")
	void delete(@Param("id") final long id);

	//未作成↓
	/** 対象のレコードを削除する
	@Transactional
	@Modifying
	@Query("DELETE FROM ChampionMainTiba WHERE id IN(:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);
	*/
}
