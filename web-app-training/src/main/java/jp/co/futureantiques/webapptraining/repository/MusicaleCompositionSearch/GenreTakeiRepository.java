package jp.co.futureantiques.webapptraining.repository.MusicaleCompositionSearch;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.GenreTakei;

/**
 * GenreTakeiリポジトリのインターフェース
 *
 * @author takei
 */

public interface GenreTakeiRepository extends  JpaRepository<GenreTakei, Long>{
}
