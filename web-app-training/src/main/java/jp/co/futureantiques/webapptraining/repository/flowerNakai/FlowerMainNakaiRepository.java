package jp.co.futureantiques.webapptraining.repository.flowerNakai;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.webapptraining.model.flowerNakai.FlowerMainNakai;

/**
 * FlowerMainNakaiリポジトリのインターフェース
 * @author Rieko Nakai
 */
public interface FlowerMainNakaiRepository extends JpaRepository<FlowerMainNakai,Long>,JpaSpecificationExecutor<FlowerMainNakai> {

	/**
	 * 対象レコードの削除フラグを1にする
	 * @param long id
	 */
	@Transactional
	@Modifying
	@Query("update FlowerMainNakai set delFlg=1 where id= :id")
	void delete(@Param("id") final long id);

	/**
	 * 対象のレコードを削除する
	 * @param ArrayList<Long> ids
	 */
	@Transactional
	@Modifying
	@Query("delete from FlowerMainNakai where id in (:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);

}
