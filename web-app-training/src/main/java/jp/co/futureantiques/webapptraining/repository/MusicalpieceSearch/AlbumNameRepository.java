package jp.co.futureantiques.webapptraining.repository.MusicalpieceSearch;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.AlbumRuike;

/**
 * AlbumRuikeリポジトリのインターフェース
 */

public interface AlbumNameRepository extends JpaRepository<AlbumRuike, Long> {

}
