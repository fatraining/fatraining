package jp.co.futureantiques.webapptraining.repository.MusicaleCompositionSearch;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.AlbumTakei;

/**
 * AlbumTakeiリポジトリのインターフェース
 *
 * @author takei
 */

public interface AlbumTakeiRepository extends JpaRepository<AlbumTakei, Long>{
}
