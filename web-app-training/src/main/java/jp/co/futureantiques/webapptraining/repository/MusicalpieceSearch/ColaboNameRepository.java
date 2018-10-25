package jp.co.futureantiques.webapptraining.repository.MusicalpieceSearch;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.ColaboRuike;

/**
 * ColaboNameリポジトリのインターフェース
 *
 * @author future
 */

public interface ColaboNameRepository extends JpaRepository<ColaboRuike, Long> {

}
