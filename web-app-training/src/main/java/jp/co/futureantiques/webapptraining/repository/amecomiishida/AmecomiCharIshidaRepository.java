package jp.co.futureantiques.webapptraining.repository.amecomiishida;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.webapptraining.model.amecomiishida.AmecomiCharIshida;

/**
 * @author ishida
 * AmecomiCharIshidaリポジトリのインターフェース。
 */
@Repository
public interface AmecomiCharIshidaRepository extends JpaRepository<AmecomiCharIshida, Long>, JpaSpecificationExecutor<AmecomiCharIshida> {

	/**
	 * 対象のレコードの削除フラグを１にする
	 *
	 *@param long id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE AmecomiCharIshida SET delFlg = 1 WHERE id = :id")
	void delete(@Param("id") final long id);

	/**
	 * 対象のレコードを削除する
	 *
	 *@param ArrayLisu<Long> ids
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM AmecomiCharIshida WHERE id IN(:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);

}
