package jp.co.futureantiques.webapptraining.repository.musickichise;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.musickichise.Artist;

/**
 * Artistリポジトリのインターフェース
 *
 * @author future
 */
public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
