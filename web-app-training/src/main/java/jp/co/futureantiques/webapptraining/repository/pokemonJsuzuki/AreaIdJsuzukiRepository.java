package jp.co.futureantiques.webapptraining.repository.pokemonJsuzuki;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import jp.co.futureantiques.webapptraining.model.pokemonJsuzuki.AreaIdJsuzuki;

/**
 * typeIdリポジトリのインターフェース
 * @author j.suzuki
 *
 */
public interface AreaIdJsuzukiRepository extends JpaRepository<AreaIdJsuzuki,Long>,JpaSpecificationExecutor<AreaIdJsuzuki>
{

}
