package jp.co.futureantiques.webapptraining.repository.doramasample;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.doramasample.DoramaGenre;

/**
 * DoramaGenreリポジトリのインターフェース
 *
 * @author hiraoka
 */
public interface DoramaGenreRepository extends JpaRepository<DoramaGenre, Long> {
}