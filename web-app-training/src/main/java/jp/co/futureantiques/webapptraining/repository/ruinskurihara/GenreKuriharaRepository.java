package jp.co.futureantiques.webapptraining.repository.ruinskurihara;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.RuinsKurihara.GenreKurihara;

/**
 * Genreリポジトリのインターフェース
 *
 * @author M.Kurihara
 */
public interface GenreKuriharaRepository extends JpaRepository<GenreKurihara, Long> {
}
