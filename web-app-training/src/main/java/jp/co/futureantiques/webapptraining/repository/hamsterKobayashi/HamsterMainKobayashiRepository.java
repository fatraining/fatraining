package jp.co.futureantiques.webapptraining.repository.hamsterKobayashi;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.webapptraining.model.TypeKobayashi.HamsterMainKobayashi;

//HamsterMainKobayashiリポジトリのインターフェース
public interface HamsterMainKobayashiRepository extends JpaRepository<HamsterMainKobayashi, Long>,JpaSpecificationExecutor<HamsterMainKobayashi>{


	//対象のレコードの削除フラグを1にする

	@Transactional
	@Modifying
	@Query("UPDATE HamsterMainKobayashi SET delFlg = 1 WHERE id = :id")
	void dalete(@Param("id") final long id);


	//対象のレコードを削除する

	@Transactional
	@Modifying
	@Query("DELETE FROM HamsterMainKobayashi WHERE id IN(:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);

}
