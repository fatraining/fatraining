package jp.co.futureantiques.webapptraining.repository.pokemonJsuzuki;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.futureantiques.webapptraining.model.pokemonJsuzuki.PokemonMainJsuzuki;

/**
 * pokemonMainJsuzukiリポジトリのインターフェース
 * @author j.suzuki
 *
 */
public interface PokemonMainJsuzukiRepository extends JpaRepository<PokemonMainJsuzuki,Long>,JpaSpecificationExecutor<PokemonMainJsuzuki>
{
	/**対象のレコードの削除フラグを1にする
	 *
	 * @param long id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE PokemonMainJsuzuki SET delFlg = 1 WHERE id = :id")
	void delete(@Param("id")final long id);

	/**
	 * 対象のレコードを削除する
	 *
	 * @param ArrayList<Long>ids
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM PokemonMainJsuzuki WHERE id IN(:ids)")
	void deleteComp(@Param("ids")final ArrayList<Long> ids);


}
