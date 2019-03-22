package jp.co.futureantiques.webapptraining.repository.catNihonyanagi;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.webapptraining.model.catNihonyanagi.CatMainNihonyanagi;

/**
 * CatMainリポジトリのインターフェース
 * @author Nihonyanagi
 *
 */
public interface CatMainNihonyanagiRepository extends JpaRepository<CatMainNihonyanagi, Long>, JpaSpecificationExecutor<CatMainNihonyanagi>{

	/**
	 * 対象レコードの削除フラグを1にする
	 * @palam long id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE CatMainNihonyanagi SET delFlg=1 WHERE id= :id")
	void delete(@Param("id") final long id);

	/**
	 * 対象のレコードを削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM CatMainNihonyanagi WHERE id IN(:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);

}
