package jp.co.futureantiques.webapptraining.repository.pokemonJsuzuki;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import jp.co.futureantiques.webapptraining.model.pokemonJsuzuki.TypeIdJsuzuki;
/**
 * Typeリポジトリのインターフェース
 * @author j.suzuki
 *
 */

public interface TypeIdJsuzukiRepository extends JpaRepository<TypeIdJsuzuki,Long>,JpaSpecificationExecutor<TypeIdJsuzuki>
{

}
