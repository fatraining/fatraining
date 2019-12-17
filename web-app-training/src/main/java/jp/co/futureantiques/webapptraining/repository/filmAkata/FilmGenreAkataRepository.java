package jp.co.futureantiques.webapptraining.repository.filmAkata;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.filmAkata.FilmGenreAkata;

/**
 * FilmGenreAkataリポジトリのインターフェース
 *
 * @author future
 */
public interface FilmGenreAkataRepository extends JpaRepository<FilmGenreAkata, Long> {

}
