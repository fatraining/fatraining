package jp.co.futureantiques.webapptraining.repository.novelmiyamoto;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.novelmiyamoto.GenreMiyamoto;

/**
 * Genreリポジトリのインターフェース
 */
public interface GenreMiyamotoRepository extends JpaRepository<GenreMiyamoto, Long> {
}