package jp.co.futureantiques.webapptraining.repository.MusicalpieceSearch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.ArianaMainRuike;

/**
 * ArianaMainリポジトリのインターフェース
 *
 * @author future
 */
public interface ArianaMainRepository
		extends JpaRepository<ArianaMainRuike, Long>, JpaSpecificationExecutor<ArianaMainRuike> {

}
