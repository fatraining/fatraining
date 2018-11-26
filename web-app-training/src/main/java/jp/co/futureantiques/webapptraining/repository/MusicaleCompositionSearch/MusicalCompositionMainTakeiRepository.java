package jp.co.futureantiques.webapptraining.repository.MusicaleCompositionSearch;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.MusicalCompositionMainTakei;

public interface MusicalCompositionMainTakeiRepository extends JpaRepository
                  <MusicalCompositionMainTakei, Long>, JpaSpecificationExecutor<MusicalCompositionMainTakei>{

	/**
	 * 対象のレコードの削除フラグを1にする
	 *
	 * @param long id
	 */

	@Transactional
	@Modifying
	@Query("UPDATE MusicalCompositionMainTakei SET delFlg = 1 WHERE id = :id")
	void delete(@Param("id") final long id);


	@Transactional
	@Modifying
	@Query("DELETE FROM MusicalCompositionMainTakei WHERE id IN(:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);
}
